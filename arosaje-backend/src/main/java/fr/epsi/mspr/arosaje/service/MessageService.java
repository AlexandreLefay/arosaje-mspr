package fr.epsi.mspr.arosaje.service;


import fr.epsi.mspr.arosaje.entity.Message;
import fr.epsi.mspr.arosaje.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling message data operations.
 */
@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
