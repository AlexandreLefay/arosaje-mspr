package fr.epsi.mspr.arosaje.service;


import fr.epsi.mspr.arosaje.entity.Guardianship;
import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.entity.dto.guardianship.GuardianshipDTO;
import fr.epsi.mspr.arosaje.entity.dto.guardianship.GuardianshipSaveRequest;
import fr.epsi.mspr.arosaje.entity.mapper.GuardianshipMapper;
import fr.epsi.mspr.arosaje.repository.GuardianshipRepository;
import fr.epsi.mspr.arosaje.repository.PlantRepository;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for handling Guardianship data operations.
 */
@Service
public class GuardianshipService {

    private GuardianshipRepository guardianshipRepository;

    private GuardianshipMapper guardianshipMapper;

    private UserRepository userRepository;

    private PlantRepository plantRepository;

    public GuardianshipService(GuardianshipRepository guardianshipRepository, GuardianshipMapper guardianshipMapper, UserRepository userRepository, PlantRepository plantRepository) {
        this.guardianshipRepository = guardianshipRepository;
        this.guardianshipMapper = guardianshipMapper;
        this.userRepository = userRepository;
        this.plantRepository = plantRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<GuardianshipDTO> findAll() {
        List<Guardianship> guardianships = guardianshipRepository.findAll();

        return guardianships.stream()
                .map(guardianshipMapper::guardianshipToGuardianshipDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve all guardianships for a specific user based on the owner of the plant's owner id.
     *
     * @param userId The ID of the owner to retrieve guardianships for.
     * @return a list of guardianships for the specified user.
     */
    public List<GuardianshipDTO> findAllByOwnerUserId(Long userId) {
        List<Guardianship> guardianships = guardianshipRepository.findAllByOwnerUserId(userId);

        return guardianships.stream()
                .map(guardianshipMapper::guardianshipToGuardianshipDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve all guardianships for a specific user based on the guardian of the plant's guardian id.
     *
     * @param userId The ID of the guardian to retrieve guardianships for.
     * @return a list of guardianships for the specified user.
     */
    public List<GuardianshipDTO> findAllByGuardianUserId(Long userId) {
        List<Guardianship> guardianships = guardianshipRepository.findAllByGuardianUserId(userId);

        return guardianships.stream()
                .map(guardianshipMapper::guardianshipToGuardianshipDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieve a guardianship by its ID.
     *
     * @param id The ID of the guardianship to retrieve.
     * @return the guardianship with the specified ID.
     */
    public GuardianshipDTO findById(Long id) {
        List<GuardianshipDTO> guardianships = findAll();

        return guardianships.stream()
                .filter(guardianship -> guardianship.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Update an existing guardianship.
     *
     * @param guardianshipSaveRequest The GuardianshipDTO containing the updated information for the guardianship.
     * @return the updated guardianship.
     */
    public GuardianshipDTO update(GuardianshipSaveRequest guardianshipSaveRequest) {

        Guardianship guardianship = guardianshipRepository.findById(guardianshipSaveRequest.getId())
                .orElseThrow(() -> new RuntimeException("Guardianship not found"));

        guardianshipMapper.updateGuardianshipFromGuardianshipSaveRequest(guardianshipSaveRequest, guardianship);
        return guardianshipMapper.guardianshipToGuardianshipDTO(guardianshipRepository.save(guardianship));
    }

    /**
     * Create a new guardianship.
     *
     * @param guardianshipDTO The GuardianshipDTO containing the new guardianship's information.
     * @return the created guardianship.
     */
    public GuardianshipDTO create(GuardianshipDTO guardianshipDTO) {
        Guardianship guardianship = guardianshipMapper.guardianshipDTOToGuardianship(guardianshipDTO);

        User owner = userRepository.findById(guardianshipDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User guardian = userRepository.findById(guardianshipDTO.getGuardianId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Plant plant = plantRepository.findById(guardianshipDTO.getPlantId())
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        guardianship.setOwnerUser(owner);
        guardianship.setGuardianUser(guardian);
        guardianship.setPlant(plant);
        return guardianshipMapper.guardianshipToGuardianshipDTO(guardianshipRepository.save(guardianship));
    }

    /**
     * Delete a guardianship by its ID.
     *
     * @param id The ID of the guardianship to delete.
     */
    public void delete(Long id) {
        if (!guardianshipRepository.existsById(id)) {
            throw new RuntimeException("Guardianship not found");
        }
        guardianshipRepository.deleteById(id);
    }
}

