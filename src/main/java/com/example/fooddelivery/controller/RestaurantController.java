package com.example.fooddelivery.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository repo;

    public RestaurantController(RestaurantRepository repo) {
        this.repo = repo;
    }

    // CREATE RESTAURANT
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return repo.save(restaurant);
    }

    // GET ALL RESTAURANTS
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return repo.findAll();
    }

    // GET RESTAURANT BY ID
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE RESTAURANT
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {

        Restaurant existingRestaurant = repo.findById(id).orElse(null);

        if (existingRestaurant != null) {
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setLocation(restaurant.getLocation());
            existingRestaurant.setRating(restaurant.getRating());
            existingRestaurant.setCuisineType(restaurant.getCuisineType());

            return repo.save(existingRestaurant);
        }

        return null;
    }
}