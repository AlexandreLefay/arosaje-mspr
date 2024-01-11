package fr.epsi.mspr.arosaje.service;


import fr.epsi.mspr.arosaje.entity.Ticket;
import fr.epsi.mspr.arosaje.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling ticket data operations.
 */
@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }
}
