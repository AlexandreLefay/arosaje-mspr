package fr.epsi.mspr.arosaje.entity.mapper;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.Plant;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoResponseDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantCreationDto;
import fr.epsi.mspr.arosaje.entity.dto.plant.PlantResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlantMapper {
    PlantMapper INSTANCE = Mappers.getMapper(PlantMapper.class);

    PlantCreationDto plantToPlantCreationDto(Plant plant);
    Plant plantCreationDtoToPlant(PlantCreationDto plantCreationDto);


    @Mapping(source = "careInstructions", target = "careInstructions")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    @Mapping(source = "user.id", target = "userId")

    PlantResponseDto plantToPlantResponseDto(Plant plant);

    /**
     * Converts a TicketComment entity to a TicketCommentDTO.
     *
     * @param photo The TicketComment entity to be converted.
     * @return The corresponding TicketCommentDTO.
     */
    @Mapping(source = "user.id", target = "userId")
    PhotoResponseDto photoToPhotoResponseDto(Photo photo);

    void updatePlantFromDto(PlantCreationDto plantCreationDto, @MappingTarget Plant plant);

    // mapping for userId
    void updateUserId(Long userId, @MappingTarget Plant plant);
}
