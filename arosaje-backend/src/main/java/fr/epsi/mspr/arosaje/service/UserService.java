package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for handling user data operations.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Retrieve all users.
     *
     * @return a list of all users.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }
}