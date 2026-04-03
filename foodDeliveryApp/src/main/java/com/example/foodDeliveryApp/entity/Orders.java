package com.example.foodDeliveryApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user_orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private int quantity;

    private Long foodItemId;

    private int totalPrice;

    private String status = "PENDING";
}
