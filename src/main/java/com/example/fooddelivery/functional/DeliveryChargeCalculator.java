
package com.example.fooddelivery.functional;

@FunctionalInterface
public interface DeliveryChargeCalculator {
    double calculate(double price);
}
