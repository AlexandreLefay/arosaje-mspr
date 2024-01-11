package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
