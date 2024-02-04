package fr.epsi.mspr.arosaje.entity.mapper;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoCreationDto;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    PhotoCreationDto photoToPhotoCreationDto(Photo photo);

    @Mapping(source = "createdAt", target = "createdAt")
    PhotoResponseDto photoToPhotoResponseDto(Photo photo);

    void updatePhotoFromDto(PhotoCreationDto photoCreationDto, @MappingTarget Photo photo);

    // mapping for userId
    void updateUserId(Long userId, @MappingTarget Photo photo);

    Photo photoCreationDtoToPhoto(PhotoCreationDto photoCreationDto);
}
