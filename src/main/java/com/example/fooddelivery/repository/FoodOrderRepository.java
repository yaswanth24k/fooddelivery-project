
package com.example.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fooddelivery.model.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
