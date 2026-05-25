
package com.example.fooddelivery.model;

import jakarta.persistence.Entity;

@Entity
public class RegularCustomer extends User {

    private int loyaltyPoints;
    private String preferredPayment;

    @Override
    public double calculateDiscount() {
        return loyaltyPoints > 100 ? 10 : 0;
    }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    public String getPreferredPayment() { return preferredPayment; }
    public void setPreferredPayment(String preferredPayment) { this.preferredPayment = preferredPayment; }
}
