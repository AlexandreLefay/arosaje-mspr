package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.dto.guardianship.validation.MandatoryGuardianshipId;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantResponseDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantSaveRequest;
import fr.epsi.mspr.arosaje.entity.dto.plant.validation.MandatoryPlanId;
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
    public List<PlantResponseDto> getAllPlants() {
        return plantService.findAll();
    }

    /**
     * Retrieves all plants for a specific user.
     *
     * @param userId The ID of the user to retrieve plants for.
     * @return the list of plants.
     */
    @GetMapping("/user/{userId}")
    public List<PlantResponseDto> getAllPlantsByUserId(@PathVariable Long userId) {
        return plantService.findByUserId(userId);
    }


    /**
     * Retrieves a plant by its ID.
     *
     * @param id The ID of the plant to retrieve.
     * @return the plant.
     */
    public PlantResponseDto getPlantById(Long id) {
        return plantService.findById(id);
    }

    /**
     * Creates a new plant.
     *
     * @param plantSaveRequest The plant to create.
     * @return the created plant.
     */
    @PostMapping()
    public PlantResponseDto createPlant(@RequestBody PlantSaveRequest plantSaveRequest) {
        return plantService.create(plantSaveRequest);
    }

    /**
     * Updates a plant.
     *
     * @param plantSaveRequest The updated plant.
     * @return the updated plant.
     */
    @PutMapping("/{id}")
    public PlantResponseDto updatePlant(@Validated(MandatoryPlanId.class) @RequestBody PlantSaveRequest plantSaveRequest) {
        return plantService.update(plantSaveRequest);
    }

    /**
     * Deletes a plant.
     *
     * @param id The ID of the plant to delete.
     */
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.delete(id);
    }


}

