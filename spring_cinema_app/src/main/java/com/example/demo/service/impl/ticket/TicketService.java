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
    private ITicketRepository iTicketRepository;
    @Override
    public Page<Ticket> searchTicket(String name, Pageable pageable) {
        return iTicketRepository.searchTicket(name,pageable);
    }

    public List<Ticket> findAllTicketByCustomer(Customer customer) {
        return iTicketRepository.findTicketByCustomer(customer.getId());
    }

    public Optional<Ticket> detail(String id) {
        return iTicketRepository.findById(id);
    }

    @Override
    public Boolean bookingConfirmation(String id) {
        try {
            iTicketRepository.bookingConfirmation(id);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public Boolean deleteTicket(String id) {
        try {
            iTicketRepository.bookingConfirmation(id);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }

    }
}