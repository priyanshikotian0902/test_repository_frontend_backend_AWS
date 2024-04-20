package com.s30project.s30project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id) {
        userService.updateUser(user, id);
        return user;
    }
    @PostMapping("/users/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        List<User> users = userService.getAllUsers();

        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                // If the credentials match, return the authenticated user
                return ResponseEntity.ok(u);
            }
        }

        // If no user is found with matching credentials, return an error response
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
}
