package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.TicketComment;
import fr.epsi.mspr.arosaje.repository.TicketCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling TicketComment data operations.
 */
@Service
public class TicketCommentService {

    private TicketCommentRepository ticketCommentRepository;

    public TicketCommentService(TicketCommentRepository ticketCommentRepository) {
        this.ticketCommentRepository = ticketCommentRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<TicketComment> findAll() {
        return ticketCommentRepository.findAll();
    }
}
