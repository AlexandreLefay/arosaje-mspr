package fr.epsi.mspr.arosaje.entity.dto.photo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PhotoResponseDto {
    private int id;
    private int referenceId;
    private String referenceType;
    private byte[] imageBlob;
    private LocalDateTime createdAt;
}
