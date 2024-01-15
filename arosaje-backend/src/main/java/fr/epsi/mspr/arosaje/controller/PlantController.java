package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantCreationDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantResponseDto;
import fr.epsi.mspr.arosaje.entity.mapper.PlantMapper;
import fr.epsi.mspr.arosaje.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // GETTING ALL PLANTS
    @GetMapping
    public ResponseEntity<List<PlantResponseDto>> getAllPlants() {
        List<Plant> plants = plantService.findAll();
        List<PlantResponseDto> responseDtos = plants.stream()
                .map(PlantMapper.INSTANCE::plantToPlantResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }


    // GETTING PLANT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantResponseDto> getPlantById(@PathVariable int id) {
        Plant plant = plantService.findById(id);
        return plant != null
                ? new ResponseEntity<>(PlantMapper.INSTANCE.plantToPlantResponseDto(plant), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // CREATE PLANT

    @PostMapping
    public ResponseEntity<PlantResponseDto> createPlant(@RequestBody PlantCreationDto plantDto) {
        Plant plant = PlantMapper.INSTANCE.plantCreationDtoToPlant(plantDto);

        // add userId when creating a plant
        Plant createdPlant = plantService.save(plant, plantDto.getUserId());

        PlantResponseDto responseDto = PlantMapper.INSTANCE.plantToPlantResponseDto(createdPlant);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    // UPDATE A PLANT
    @PutMapping("/{id}")
    public ResponseEntity<PlantResponseDto> updatePlant(@PathVariable int id, @RequestBody PlantCreationDto updatedPlantDto) {
        Plant updatedPlant = plantService.findById(id);
        if (updatedPlant != null) {
            PlantMapper plantMapper = PlantMapper.INSTANCE;
            plantMapper.updatePlantFromDto(updatedPlantDto, updatedPlant);

            // add userId when updating a plant
            Plant result = plantService.update(id, updatedPlant, updatedPlantDto.getUserId());

            if (result != null) {
                PlantResponseDto responseDto = plantMapper.plantToPlantResponseDto(result);
                return new ResponseEntity<>(responseDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // DELETE A PLANT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable int id) {
        boolean deleted = plantService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

