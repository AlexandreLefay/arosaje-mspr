package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
