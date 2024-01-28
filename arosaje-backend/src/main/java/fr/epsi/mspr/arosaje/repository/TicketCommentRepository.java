package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketCommentRepository extends JpaRepository<TicketComment, Long> {
    /**
     * Finds all ticket comments based on the given ticket ID.
     *
     * @param ticketId The ID of the ticket.
     * @return A list of TicketComment entities.
     */
    List<TicketComment> findByTicketId(int ticketId);
}
