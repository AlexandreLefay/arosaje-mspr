package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling photo data operations.
 */
@Service
public class PhotoService {

    private PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<Photo> findAll() {
        return photoRepository.findAll();
    }
}
