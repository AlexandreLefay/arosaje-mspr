package fr.epsi.mspr.arosaje.controller;


import fr.epsi.mspr.arosaje.entity.TicketComment;
import fr.epsi.mspr.arosaje.service.TicketCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing ticket comments.
 */
@RestController
@RequestMapping("/api/ticket-comments")
public class TicketCommentController {

    @Autowired
    private TicketCommentService ticketCommentService;

    /**
     * GET /api/ticket-comments : get all the ticket comments.
     *
     * @return the list of ticket comments.
     */
    @GetMapping
    public List<TicketComment> getAllTicketComments() {
        return ticketCommentService.findAll();
    }
}
