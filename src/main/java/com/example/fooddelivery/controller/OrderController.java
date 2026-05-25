package com.example.fooddelivery.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.fooddelivery.model.FoodOrder;
import com.example.fooddelivery.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // PROCESS ORDER
    @PostMapping("/process")
    public FoodOrder processOrder(@RequestBody FoodOrder order) {
        return service.processOrder(order);
    }

    // GET ALL ORDERS
    @GetMapping
    public List<FoodOrder> getOrders() {
        return service.getAllOrders();
    }

    // GET ORDER BY ID
    @GetMapping("/{id}")
    public FoodOrder getOrderById(@PathVariable Long id) {
        return service.getAllOrders()
                .stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}