package fr.epsi.mspr.arosaje.entity.dto.plant;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PlantResponseDto {
    private int id;
    private String name;
    private String species;
    private String careInstructions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
