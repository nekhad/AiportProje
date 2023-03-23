package com.example.aiportproject.service;


import com.example.aiportproject.entity.Ticket;
import com.example.aiportproject.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;



    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }


    public void createTicket(Ticket ticket) {
       ticketRepository.save(ticket);
        }


    public void updateTicket(Long id, Ticket ticket) {
        Optional<Ticket> existingTicket = ticketRepository.findById(id);
        if (existingTicket.isPresent()) {
            ticket.setId(id);
            ticketRepository.save(ticket);
        } else {
            throw new RuntimeException("Ticket not found");
        }
    }

    public void deleteTicket(Long id) {
        Optional<Ticket> existingTicket = ticketRepository.findById(id);
        if (existingTicket.isPresent()) {
            ticketRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ticket not found");
        }
    }
}

