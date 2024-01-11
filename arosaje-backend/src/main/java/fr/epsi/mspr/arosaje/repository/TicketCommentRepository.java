package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCommentRepository extends JpaRepository<TicketComment, Long> {
}
