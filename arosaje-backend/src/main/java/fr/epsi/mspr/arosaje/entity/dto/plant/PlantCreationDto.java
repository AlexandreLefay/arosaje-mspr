package fr.epsi.mspr.arosaje.entity.dto.plant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantCreationDto {
    private String name;
    private String species;
    private String careInstructions;
    private Long userId;

    // setter for userId
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
