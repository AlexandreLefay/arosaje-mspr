package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import fr.epsi.mspr.arosaje.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {

    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository, UserRepository userRepository) {
        this.plantRepository = plantRepository;
        this.userRepository = userRepository;
    }

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public Plant findById(int id) {
        Optional<Plant> optionalPlant = plantRepository.findById((long) id);
        return optionalPlant.orElse(null);
    }

    public List<Plant> findByUserId(Long userId) {
        return plantRepository.findByUserId(userId);
    }

    public Plant save(Plant plant, Long userId) {
        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);
            userOptional.ifPresent(plant::setUser);
        }
        return plantRepository.save(plant);
    }

    public Plant update(int id, Plant updatedPlant, Long userId) {
        if (plantRepository.existsById((long) id)) {
            updatedPlant.setId(id);

            // add userId when updating a plant
            if (userId != null) {
                Optional<User> userOptional = userRepository.findById(userId);
                userOptional.ifPresent(updatedPlant::setUser);
            }

            return plantRepository.save(updatedPlant);
        }
        return null;
    }

    public boolean deleteById(int id) {
        if (plantRepository.existsById((long) id)) {
            plantRepository.deleteById((long) id);
            return true;
        }
        return false;
    }
}