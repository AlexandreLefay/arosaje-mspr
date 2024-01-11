package fr.epsi.mspr.arosaje.controller;


import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing plants.
 */
@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    /**
     * GET /api/plants : get all the plants.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of plants in body.
     */
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.findAll();
    }
}
