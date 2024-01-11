package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
