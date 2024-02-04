package fr.epsi.mspr.arosaje.entity.dto.photo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoCreationDto {
    private int referenceId;
    private String referenceType;
    private byte[] imageBlob;
    private Long userId;

    // getter and setter for userId
    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }
}
