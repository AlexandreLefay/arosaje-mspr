package fr.epsi.mspr.arosaje.service.agency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.*;

import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantResponseDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantSaveRequest;
import fr.epsi.mspr.arosaje.exception.plant.PlantInUseException;
import fr.epsi.mspr.arosaje.exception.plant.PlantNotFoundException;
import fr.epsi.mspr.arosaje.repository.GuardianshipRepository;
import fr.epsi.mspr.arosaje.repository.PlantRepository;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import fr.epsi.mspr.arosaje.entity.mapper.PlantMapper;
import fr.epsi.mspr.arosaje.service.PlantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlantServiceTest {

    @Mock
    private PlantRepository plantRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private GuardianshipRepository guardianshipRepository;

    @Mock
    private PlantMapper plantMapper;

    @InjectMocks
    private PlantService plantService;

    private Plant plant;
    private User user;
    private PlantResponseDto plantResponseDto;
    private PlantSaveRequest plantSaveRequest;

    @BeforeEach
    void setUp() {
        plant = new Plant();
        user = new User();
        plantResponseDto = new PlantResponseDto();
        plantSaveRequest = new PlantSaveRequest();

        plant.setId(1);
        user.setId(1);
        plant.setUser(user);
        plant.setCreatedAt(LocalDateTime.now());
        plant.setUpdatedAt(LocalDateTime.now());
    }

    @Test
    void findAll_ShouldReturnListOfPlants() {
        given(plantRepository.findAll()).willReturn(Collections.singletonList(plant));
        given(plantMapper.plantToPlantResponseDto(any(Plant.class))).willReturn(plantResponseDto);

        List<PlantResponseDto> result = plantService.findAll();

        then(plantRepository).should(times(1)).findAll();
        assertThat(result).isNotNull().hasSize(1);
        assertThat(result.get(0)).isSameAs(plantResponseDto);
    }

    @Test
    void findById_ExistingId_ShouldReturnPlant() {
        given(plantRepository.findById(anyLong())).willReturn(Optional.of(plant));
        given(plantMapper.plantToPlantResponseDto(any(Plant.class))).willReturn(plantResponseDto);

        PlantResponseDto result = plantService.findById(1L);

        then(plantRepository).should(times(1)).findById(1L);
        assertThat(result).isNotNull();
        assertThat(result).isSameAs(plantResponseDto);
    }

    @Test
    void findById_NonExistingId_ShouldThrowException() {
        given(plantRepository.findById(anyLong())).willReturn(Optional.empty());

        assertThatThrownBy(() -> plantService.findById(1L))
                .isInstanceOf(PlantNotFoundException.class);

        then(plantRepository).should(times(1)).findById(1L);
    }

    @Test
    void update_ExistingId_ShouldUpdatePlant() {
        // Given
        given(plantRepository.findById(anyLong())).willReturn(Optional.of(plant));
        given(plantRepository.save(any(Plant.class))).willReturn(plant);
        given(plantMapper.plantToPlantResponseDto(any(Plant.class))).willReturn(plantResponseDto);

        // Additional setup for the update
        plantSaveRequest.setId(1L); // Assuming this is how you identify the plant to update
        plantSaveRequest.setUserId((long) user.getId());

        // When
        PlantResponseDto result = plantService.update(plantSaveRequest);

        // Then
        then(plantRepository).should(times(1)).findById(plantSaveRequest.getId());
        then(plantRepository).should(times(1)).save(plant);
        assertThat(result).isNotNull();
        assertThat(result).isSameAs(plantResponseDto);
    }

    @Test
    void delete_ExistingId_ShouldDeletePlant() {
        // Given
        long plantId = 1L;
        given(plantRepository.existsById(plantId)).willReturn(true);
        willDoNothing().given(plantRepository).deleteById(plantId);
        given(guardianshipRepository.existsByPlantId(plantId)).willReturn(false);

        // When
        plantService.delete(plantId);

        // Then
        then(plantRepository).should(times(1)).existsById(plantId);
        then(plantRepository).should(times(1)).deleteById(plantId);
        then(guardianshipRepository).should(times(1)).existsByPlantId(plantId);
    }

    @Test
    void delete_WithPlantInUse_ShouldThrowException() {
        // Given
        long plantId = 1L;
        given(plantRepository.existsById(plantId)).willReturn(true);
        given(guardianshipRepository.existsByPlantId(plantId)).willReturn(true);

        // When & Then
        assertThatThrownBy(() -> plantService.delete(plantId))
                .isInstanceOf(PlantInUseException.class)
                .hasMessageContaining("Plant with id " + plantId + " is in use");

        then(plantRepository).should(times(1)).existsById(plantId);
        then(guardianshipRepository).should(times(1)).existsByPlantId(plantId);
        then(plantRepository).shouldHaveNoMoreInteractions();
    }

}
