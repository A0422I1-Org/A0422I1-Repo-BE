package com.example.demo.service.ticket;


import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;

import java.util.List;



import com.example.demo.model.ticket.Ticket;
import org.springframework.stereotype.Service;


@Service
public interface ITicketService {
    List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom,Integer idShowTime);
    List<Ticket>findAllTicketByCustomer(Customer customer);

}
