package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.TicketComment;
import fr.epsi.mspr.arosaje.entity.dto.ticket.TicketCommentCreationDTO;
import fr.epsi.mspr.arosaje.entity.dto.ticket.TicketCommentDTO;
import fr.epsi.mspr.arosaje.entity.mapper.TicketCommentMapper;
import fr.epsi.mspr.arosaje.repository.TicketCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling operations related to TicketComment data.
 */
@Service
public class TicketCommentService {

    @Autowired
    private TicketCommentRepository ticketCommentRepository;

    /**
     * Retrieves all comments associated with a specific ticket.
     *
     * @param ticketId The ID of the ticket for which comments are to be retrieved.
     * @return A list of TicketCommentDTOs representing the comments for the specified ticket.
     */
    public List<TicketCommentDTO> getAllCommentsByTicket(int ticketId) {
        List<TicketComment> comments = ticketCommentRepository.findByTicketId(ticketId);
        return comments.stream()
                .map(TicketCommentMapper.INSTANCE::ticketCommentToTicketCommentDTO)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new comment for a ticket.
     *
     * @param ticketId   The ID of the ticket to which the comment is to be added.
     * @param commentDTO The DTO containing the comment creation information.
     * @return The created TicketCommentDTO.
     */
    public TicketCommentDTO createComment(Long ticketId, TicketCommentCreationDTO commentDTO) {
        TicketComment comment = TicketCommentMapper.INSTANCE.ticketCommentCreationDTOToTicketComment(commentDTO);
        // TODO Set ticket and user information

        TicketComment savedComment = ticketCommentRepository.save(comment);
        return TicketCommentMapper.INSTANCE.ticketCommentToTicketCommentDTO(savedComment);
    }

    /**
     * Retrieves a specific comment by its ID.
     *
     * @param commentId The ID of the comment to retrieve.
     * @return The TicketCommentDTO representing the retrieved comment.
     * @throws RuntimeException if the comment is not found.
     */
    public TicketCommentDTO getCommentById(Long commentId) {
        TicketComment comment = ticketCommentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return TicketCommentMapper.INSTANCE.ticketCommentToTicketCommentDTO(comment);
    }

    /**
     * Updates an existing comment.
     *
     * @param commentId  The ID of the comment to update.
     * @param commentDTO The DTO containing the updated information for the comment.
     * @return The updated TicketCommentDTO.
     * @throws RuntimeException if the comment is not found.
     */
    public TicketCommentDTO updateComment(Long commentId, TicketCommentCreationDTO commentDTO) {
        TicketComment existingComment = ticketCommentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        // Update the necessary fields here...

        TicketComment updatedComment = ticketCommentRepository.save(existingComment);
        return TicketCommentMapper.INSTANCE.ticketCommentToTicketCommentDTO(updatedComment);
    }

    /**
     * Deletes a comment by its ID.
     *
     * @param commentId The ID of the comment to delete.
     * @throws RuntimeException if the comment is not found.
     */
    public void deleteComment(Long commentId) {
        if (!ticketCommentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }
        ticketCommentRepository.deleteById(commentId);
    }
}