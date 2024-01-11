package fr.epsi.mspr.arosaje.controller;


import fr.epsi.mspr.arosaje.entity.Guardianship;
import fr.epsi.mspr.arosaje.service.GuardianshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing guardianships.
 */
@RestController
@RequestMapping("/api/guardianships")
public class GuardianshipController {

    @Autowired
    private GuardianshipService guardianshipService;

    /**
     * GET /api/guardianships : get all the guardianships.
     *
     * @return the list of guardianships.
     */
    @GetMapping
    public List<Guardianship> getAllGuardianships() {
        return guardianshipService.findAll();
    }
}
