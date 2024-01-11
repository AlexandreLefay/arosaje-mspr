package fr.epsi.mspr.arosaje.controller;


import fr.epsi.mspr.arosaje.entity.Ticket;
import fr.epsi.mspr.arosaje.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing tickets.
 */
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * GET /api/tickets : get all the tickets.
     *
     * @return the list of tickets.
     */
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }
}
