package fr.epsi.mspr.arosaje.entity.dto.plant;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PlantResponseDto {
    private int id;
    private String name;
    private String species;
    private String careInstructions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int userId;
    private List<PhotoResponseDto> photos;
}
