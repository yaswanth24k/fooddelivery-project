package com.example.fooddelivery.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.fooddelivery.model.User;
import com.example.fooddelivery.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // CREATE USER
    @PostMapping
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {

        User existingUser = repo.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setPhone(user.getPhone());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(user.getAddress());

            return repo.save(existingUser);
        }

        return null;
    }
}