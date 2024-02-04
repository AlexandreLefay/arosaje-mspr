package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.Photo;
import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.repository.PhotoRepository;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository, UserRepository userRepository) {
        this.photoRepository = photoRepository;
        this.userRepository = userRepository;
    }

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Photo findById(int id) {
        Optional<Photo> optionalPhoto = photoRepository.findById((long) id);
        return optionalPhoto.orElse(null);
    }

    public Photo save(Photo photo, Long userId) {
        if (userId != null) {
            Optional<User> userOptional = userRepository.findById(userId);
            userOptional.ifPresent(photo::setUser);
        }
        return photoRepository.save(photo);
    }

    public Photo update(int id, Photo updatedPhoto) {
        if (photoRepository.existsById((long) id)) {
            updatedPhoto.setId(id);
            return photoRepository.save(updatedPhoto);
        }
        return null;
    }

    public boolean deleteById(int id) {
        if (photoRepository.existsById((long) id)) {
            photoRepository.deleteById((long) id);
            return true;
        }
        return false;
    }
}
