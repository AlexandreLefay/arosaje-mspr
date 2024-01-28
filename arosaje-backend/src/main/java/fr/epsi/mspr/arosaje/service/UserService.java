package fr.epsi.mspr.arosaje.service;

import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.entity.dto.user.UserCreationDTO;
import fr.epsi.mspr.arosaje.entity.dto.user.UserDTO;
import fr.epsi.mspr.arosaje.entity.mapper.UserMapper;
import fr.epsi.mspr.arosaje.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for handling user-related operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user from the provided UserCreationDTO.
     *
     * @param userCreationDTO the user creation DTO
     * @return the created user as a UserDTO
     * @throws RuntimeException if the user cannot be created
     */
    public UserDTO createUser(UserCreationDTO userCreationDTO) throws RuntimeException {
        User user = UserMapper.INSTANCE.userDTOToUser(userCreationDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(savedUser);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to retrieve
     * @return the retrieved user as a UserDTO
     * @throws RuntimeException if the user cannot be found
     */
    public UserDTO getUserById(Long id) throws RuntimeException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    /**
     * Updates a user with the provided UserCreationDTO.
     *
     * @param id              the ID of the user to update
     * @param userCreationDTO the updated user data
     * @return the updated user as a UserDTO
     * @throws RuntimeException if the user cannot be found or updated
     */
    public UserDTO updateUser(Long id, UserCreationDTO userCreationDTO) throws RuntimeException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserMapper.INSTANCE.updateUserFromDto(userCreationDTO, user);
        User updatedUser = userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(updatedUser);
    }

    /**
     * Delete a user by his ID.
     *
     * @param id the ID of the user to delete
     * @throws RuntimeException if the user cannot be found or deleted
     */
    public void deleteUser(Long id) throws RuntimeException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
    }

    /**
     * Retrieves all users.
     *
     * @return a list of all users as UserDTOs
     */
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDTO)
                .collect(Collectors.toList());
    }
}

