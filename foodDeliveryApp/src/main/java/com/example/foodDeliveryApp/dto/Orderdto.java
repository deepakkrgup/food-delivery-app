package com.example.foodDeliveryApp.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Orderdto {
    private Long userId;
    private Long foodItemId;

    @Min(value = 1, message = "Minimum one order.")
    private int quantity;
}
