package com.example.foodDeliveryApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "fooditem")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int price;

    private String category;
}
