package com.example.demo.service.impl.ticket;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import com.example.demo.repository.ticket.ITicketRepository;
import com.example.demo.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TicketService  implements ITicketService {
    @Autowired
    private ITicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAllTicket();
    }

    @Override
    public Ticket findById(String id) {
        return ticketRepository.findTicketById(id);
    }

    @Override
    public void createOrUpdate(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void delete(String id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findAllTicketByCustomer(Customer customer) {
        return ticketRepository.findTicketByCustomer(customer);
    }

//    public List<Ticket> findAllTicketByCustomer(Customer customer) {
//        return iTicketRepository.findTicketByCustomer(customer.getId());
//    }
    @Override
    public Page<Ticket> findAllTicketByCustomer(Customer customer, Pageable pageable) {
        return ticketRepository.findTicketByCustomer(customer.getId(), pageable);
    }

    /**
     * @param
     * @return List<Ticket>
     * @content find all ticket of showtime and room now
     * @author PhatVN
     */
    @Override
    public List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom, Integer idShowTime) {
        return ticketRepository.findTicketByShowTimeAndIdRoom(idRoom,idShowTime);
    }
    @Override
    public Page<Ticket> searchTicket(String name, Pageable pageable) {
        return ticketRepository.searchTicket(name,pageable);
    }



    public Optional<Ticket> detail(String id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Boolean bookingConfirmation(String id) {
        try {
            ticketRepository.bookingConfirmation(id);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public Boolean deleteTicket(String id) {
        try {
            ticketRepository.bookingConfirmation(id);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }

    }

    @Override
    public Ticket findTicketByIdAndStatus(String id, Integer status) {
        return ticketRepository.findTicketByIdAndStatus(id, status);
    }

}