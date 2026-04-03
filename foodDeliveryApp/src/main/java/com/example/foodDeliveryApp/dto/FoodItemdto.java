package com.example.foodDeliveryApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodItemdto {
    private String name;
    private String description;
    private int price;
    private String category;
}
