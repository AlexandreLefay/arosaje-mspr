package fr.epsi.mspr.arosaje.repository;

import fr.epsi.mspr.arosaje.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
