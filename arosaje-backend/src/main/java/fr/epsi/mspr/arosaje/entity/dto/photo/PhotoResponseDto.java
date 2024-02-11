package fr.epsi.mspr.arosaje.entity.dto.photo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PhotoResponseDto {
    private Long id;
    private Long userId;
    private byte[] imageBlob;
    private LocalDateTime createdAt;
}
