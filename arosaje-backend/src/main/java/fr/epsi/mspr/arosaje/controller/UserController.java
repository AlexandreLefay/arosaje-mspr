package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.dto.user.UserCreationDTO;
import fr.epsi.mspr.arosaje.entity.dto.user.UserDTO;
import fr.epsi.mspr.arosaje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing users.
 * Provides endpoints for creating, retrieving, updating, and deleting users.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creates a new user.
     *
     * @param userCreationDTO The UserCreationDTO containing the new user's information.
     * @return ResponseEntity containing the created UserDTO.
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        UserDTO newUser = userService.createUser(userCreationDTO);
        return ResponseEntity.ok(newUser);
    }

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return ResponseEntity containing the UserDTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Updates an existing user.
     *
     * @param id              The ID of the user to update.
     * @param userCreationDTO The UserCreationDTO containing the updated information for the user.
     * @return ResponseEntity containing the updated UserDTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserCreationDTO userCreationDTO) {
        UserDTO updatedUser = userService.updateUser(id, userCreationDTO);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Deletes a user by their ID.
     *
     * @param id The ID of the user to delete.
     * @return ResponseEntity indicating the operation's success status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves all users.
     *
     * @return ResponseEntity containing a list of UserDTOs.
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}