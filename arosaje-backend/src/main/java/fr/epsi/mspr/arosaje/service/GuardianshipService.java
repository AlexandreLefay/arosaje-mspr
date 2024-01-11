package fr.epsi.mspr.arosaje.service;


import fr.epsi.mspr.arosaje.entity.Guardianship;
import fr.epsi.mspr.arosaje.repository.GuardianshipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling Guardianship data operations.
 */
@Service
public class GuardianshipService {

    private GuardianshipRepository guardianshipRepository;

    public GuardianshipService(GuardianshipRepository guardianshipRepository) {
        this.guardianshipRepository = guardianshipRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<Guardianship> findAll() {
        return guardianshipRepository.findAll();
    }
}
