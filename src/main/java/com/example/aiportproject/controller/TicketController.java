package com.example.aiportproject.controller;

import com.example.aiportproject.entity.Airport;
import com.example.aiportproject.entity.Ticket;
import com.example.aiportproject.service.AirportService;
import com.example.aiportproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




    @RestController
    @RequestMapping("/api/tickets")
    public class TicketController {

        @Autowired
        private TicketService ticketService;

        @GetMapping("/")
        public List<Ticket> getAllTickets() {
            return ticketService.getAllTickets();
        }

        @PostMapping("/")
        public void createTicket(@RequestBody Ticket ticket) {
            ticketService.createTicket(ticket);
        }

        @PutMapping("/{id}")
        public void updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
            ticketService.updateTicket(id, ticket);
        }

        @DeleteMapping("/{id}")
        public void deleteTicket(@PathVariable Long id) {
            ticketService.deleteTicket(id);
        }
    }



