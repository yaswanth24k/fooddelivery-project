
package com.example.fooddelivery.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.fooddelivery.model.*;
import com.example.fooddelivery.repository.*;
import com.example.fooddelivery.functional.DeliveryChargeCalculator;

@Service
public class OrderService {

    private final FoodOrderRepository orderRepo;

    public OrderService(FoodOrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public FoodOrder processOrder(FoodOrder order) {

        List<FoodOrder> orderList = new ArrayList<>();
        Set<Long> orderIds = new HashSet<>();
        Map<String, List<FoodOrder>> deliveryZone = new HashMap<>();

        orderList.add(order);
        orderIds.add(order.getId());

        deliveryZone.computeIfAbsent("ZONE-A", k -> new ArrayList<>()).add(order);

        DeliveryChargeCalculator calc = price -> price > 500 ? 0 : 40;

        double deliveryCharge = calc.calculate(order.getPrice());

        order.setStatus(order.getStatus() + " | DeliveryCharge:" + deliveryCharge);

        return orderRepo.save(order);
    }

    public List<FoodOrder> getAllOrders() {
        return orderRepo.findAll();
    }
}
