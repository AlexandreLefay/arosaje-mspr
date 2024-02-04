package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoCreationDto;
import fr.epsi.mspr.arosaje.entity.dto.photo.PhotoResponseDto;
import fr.epsi.mspr.arosaje.entity.mapper.PhotoMapper;
import fr.epsi.mspr.arosaje.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public ResponseEntity<List<PhotoResponseDto>> getAllPhotos() {
        List<Photo> photos = photoService.findAll();
        List<PhotoResponseDto> responseDtos = photos.stream()
                .map(PhotoMapper.INSTANCE::photoToPhotoResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoResponseDto> getPhotoById(@PathVariable int id) {
        Photo photo = photoService.findById(id);
        return photo != null
                ? ResponseEntity.ok(PhotoMapper.INSTANCE.photoToPhotoResponseDto(photo))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PhotoResponseDto> createPhoto(@RequestBody PhotoCreationDto photoDto) {
        Photo photo = PhotoMapper.INSTANCE.photoCreationDtoToPhoto(photoDto);

        // add userId when creating a photo
        Photo createdPhoto = photoService.save(photo, photoDto.getUserId());

        PhotoResponseDto responseDto = PhotoMapper.INSTANCE.photoToPhotoResponseDto(createdPhoto);
        return ResponseEntity.status(201).body(responseDto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PhotoResponseDto> updatePhoto(@PathVariable int id, @RequestBody PhotoCreationDto updatedPhotoDto) {
        Photo updatedPhoto = photoService.findById(id);
        if (updatedPhoto != null) {
            PhotoMapper.INSTANCE.updatePhotoFromDto(updatedPhotoDto, updatedPhoto);

            Photo result = photoService.update(id, updatedPhoto);
            if (result != null) {
                PhotoResponseDto responseDto = PhotoMapper.INSTANCE.photoToPhotoResponseDto(result);
                return ResponseEntity.ok(responseDto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable int id) {
        boolean deleted = photoService.deleteById(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}