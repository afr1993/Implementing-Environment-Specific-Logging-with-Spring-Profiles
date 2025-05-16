package com.example.userapi.controller;

import com.example.userapi.model.User;
import com.example.userapi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Retrieving all users");
        return userService.getAllUsers();
    }

    @PostMapping
    public HttpStatus addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            logger.info("User added: {}", user.getName());
            return HttpStatus.CREATED;
        } catch (Exception e) {
            logger.error("Error adding user: {}", e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            userService.deleteUserById(id);
            logger.info("User with id {} deleted", id);
            return HttpStatus.NO_CONTENT;
        } else {
            logger.warn("User with id {} not found", id);
            return HttpStatus.NOT_FOUND;
        }
    }
}
