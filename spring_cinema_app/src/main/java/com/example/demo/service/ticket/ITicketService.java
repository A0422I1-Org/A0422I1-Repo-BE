package com.example.demo.service.ticket;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;
import java.util.List;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.ticket.Ticket;

import java.util.List;

import com.example.demo.model.ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITicketService {
    List<Ticket> findAll();
    Ticket findById(String id);
    void createOrUpdate(Ticket ticket);
    void delete(String id);
    List<Ticket> findAllTicketByCustomer(Customer customer);
    List<Ticket> findTicketByShowTimeAndIdRoom(Integer idRoom,Integer idShowTime);
    Page<Ticket> findAllTicketByCustomer(Customer customer, Pageable pageable);
}