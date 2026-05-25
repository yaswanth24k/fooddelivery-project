
package com.example.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fooddelivery.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
