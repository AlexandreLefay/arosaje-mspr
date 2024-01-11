package fr.epsi.mspr.arosaje.service;


import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling plant data operations.
 */
@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }
    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<Plant> findAll() {
        return plantRepository.findAll();
    }
}