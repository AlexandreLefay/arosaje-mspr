package fr.epsi.mspr.arosaje.controller;

import fr.epsi.mspr.arosaje.entity.User;
import fr.epsi.mspr.arosaje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST Controller for managing users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * GET /api/users : get all the users.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of users in body.
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
