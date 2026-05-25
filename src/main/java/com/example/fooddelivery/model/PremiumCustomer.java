
package com.example.fooddelivery.model;

import jakarta.persistence.Entity;

@Entity
public class PremiumCustomer extends User {

    private String membershipLevel;
    private boolean freeDelivery;

    @Override
    public double calculateDiscount() {
        return "GOLD".equalsIgnoreCase(membershipLevel) ? 20 : 15;
    }

    public String getMembershipLevel() { return membershipLevel; }
    public void setMembershipLevel(String membershipLevel) { this.membershipLevel = membershipLevel; }

    public boolean isFreeDelivery() { return freeDelivery; }
    public void setFreeDelivery(boolean freeDelivery) { this.freeDelivery = freeDelivery; }
}
