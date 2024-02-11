package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantResponseDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantSaveRequest;
import fr.epsi.mspr.arosaje.entity.mapper.PlantMapper;
import fr.epsi.mspr.arosaje.exception.plant.PlantInUseException;
import fr.epsi.mspr.arosaje.exception.plant.PlantNotFoundException;
import fr.epsi.mspr.arosaje.exception.user.UserNotFoundException;
import fr.epsi.mspr.arosaje.repository.GuardianshipRepository;
import fr.epsi.mspr.arosaje.repository.PlantRepository;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PlantService {

    /**
     * Repositories for Plant, User, and Guardianship entities.
     */
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;
    private final GuardianshipRepository guardianshipRepository;
    private final PlantMapper plantMapper;

    /**
     * Error messages.
     */
    private static final String PLANT_IN_USE = "Plant with id {} is in use";
    private static final String PLANT_NOT_FOUND = "No plant found with id {}";
    private static final String USER_NOT_FOUND = "No user found with id {}";

    /**
     * Constructor for PlantService.
     */

    @Autowired
    public PlantService(PlantRepository plantRepository, UserRepository userRepository, GuardianshipRepository guardianshipRepository, PlantMapper plantMapper) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
        this.guardianshipRepository = guardianshipRepository;
        this.plantMapper = plantMapper;
    }

    /**
     * Retrieve all plants.
     *
     * @return a list of all plants.
     */
    public List<PlantResponseDto> findAll() {
        List<Plant> plants = plantRepository.findAll();

        return plants.stream()
                .map(plantMapper::plantToPlantResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve all plants for a specific user.
     *
     * @param userId The ID of the user to retrieve plants for.
     * @return a list of plants for the specified user.
     */
    public List<PlantResponseDto> findByUserId(Long userId) {
        List<Plant> plants = plantRepository.findByUserId(userId);

        return plants.stream()
                .map(plantMapper::plantToPlantResponseDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve a plant by its ID.
     *
     * @param id The ID of the plant to retrieve.
     * @return the plant with the specified ID.
     */
    public PlantResponseDto findById(Long id) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> {
                    log.info(PLANT_NOT_FOUND, id);
                    return new PlantNotFoundException(id);
                });

        return plantMapper.plantToPlantResponseDto(plant);
    }

    /**
     * Create a new plant.
     *
     * @param plantSaveRequest The plant to create.
     * @return the created plant.
     */
    public PlantResponseDto create(PlantSaveRequest plantSaveRequest) {
        Plant plant = plantMapper.plantSaveRequestToPlant(plantSaveRequest);

        User user = userRepository.findById(plantSaveRequest.getUserId())
                .orElseThrow(() -> {
                    log.info(USER_NOT_FOUND, plantSaveRequest.getUserId());
                    return new UserNotFoundException(plantSaveRequest.getUserId());
                });

        plant.setUser(user);
        plant.setCreatedAt(LocalDateTime.now());
        plant.setUpdatedAt(LocalDateTime.now());
        return plantMapper.plantToPlantResponseDto(plantRepository.save(plant));
    }

    /**
     * Update an existing plant.
     *
     * @param plantSaveRequest The PlantDTO containing the updated information for the plant.
     * @return the updated plant.
     */
    public PlantResponseDto update(PlantSaveRequest plantSaveRequest) {

        Plant plant = plantRepository.findById(plantSaveRequest.getId())
                .orElseThrow(() -> {
                    log.info(PLANT_NOT_FOUND, plantSaveRequest.getId());
                    return new PlantNotFoundException(plantSaveRequest.getId());
                });

        plantMapper.updatePlantFromPlantSaveRequest(plantSaveRequest, plant);
        plant.setUpdatedAt(LocalDateTime.now());
        return plantMapper.plantToPlantResponseDto(plantRepository.save(plant));
    }

    /**
     * Delete a plant by its ID.
     *
     * @param id The ID of the plant to delete.
     */
    public void delete(Long id) {
        if (!plantRepository.existsById(id)) {
            log.info(PLANT_NOT_FOUND, id);
            throw new PlantNotFoundException(id);
        }
        if (guardianshipRepository.existsByPlantId(id)) {
            log.info(PLANT_IN_USE, id);
            throw new PlantInUseException(id);
        }
        plantRepository.deleteById(id);
    }
}