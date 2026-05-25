
package com.example.fooddelivery.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularCustomer.class, name = "regular"),
        @JsonSubTypes.Type(value = PremiumCustomer.class, name = "premium")
})
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String address;

    @OneToMany(mappedBy="user")
    private List<FoodOrder> orders = new ArrayList<>();

    public abstract double calculateDiscount();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
