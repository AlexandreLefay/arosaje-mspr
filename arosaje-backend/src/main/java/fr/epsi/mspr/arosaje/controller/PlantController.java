package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.dto.plant.PlantDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantSaveRequest;
import fr.epsi.mspr.arosaje.entity.dto.plant.validation.MandatoryPlanId;
import fr.epsi.mspr.arosaje.entity.dto.plant.validation.OptionnalPlantId;
import fr.epsi.mspr.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;


    /**
     * Retrieves all plants.
     *
     * @return the list of plants.
     */
    @GetMapping()
    public List<PlantDto> getAllPlants() {
        return plantService.findAll();
    }

    /**
     * Retrieves all plants for a specific user.
     *
     * @param userId The ID of the user to retrieve plants for.
     * @return the list of plants.
     */
    @GetMapping("/user/{userId}")
    public List<PlantDto> getAllPlantsByUserId(@PathVariable Long userId) {
        return plantService.findByUserId(userId);
    }


    /**
     * Retrieves a plant by its ID.
     *
     * @param plantId The ID of the plant to retrieve.
     * @return the plant.
     */
    @GetMapping("/{plantId}")
    public PlantDto getPlantById(@PathVariable Long plantId) {
        return plantService.findById(plantId);
    }

    /**
     * Creates a new plant.
     *
     * @param plantSaveRequest The plant to create.
     * @return the created plant.
     */
    @PostMapping()
    public PlantDto createPlant(@Validated(OptionnalPlantId.class) @RequestBody PlantSaveRequest plantSaveRequest) {
        return plantService.create(plantSaveRequest);
    }

    /**
     * Updates a plant.
     *
     * @param plantSaveRequest The updated plant.
     * @return the updated plant.
     */
    @PutMapping("/{id}")
    public PlantDto updatePlant(@Validated(MandatoryPlanId.class) @RequestBody PlantSaveRequest plantSaveRequest) {
        return plantService.update(plantSaveRequest);
    }

    /**
     * Delete a plant.
     *
     * @param id The ID of the plant to delete.
     */
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.delete(id);
    }


}

