package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.Message;
import fr.epsi.mspr.arosaje.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing messages.
 */
@RestController
@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * GET /api/messages : get all the messages.
     *
     * @return the list of messages.
     */
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.findAll();
    }
}
