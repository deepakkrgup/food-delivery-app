package com.example.foodDeliveryApp.service;

import com.example.foodDeliveryApp.dto.FoodItemdto;
import com.example.foodDeliveryApp.entity.FoodItem;

import java.util.List;

public interface FoodItemService {
    String addFoodItem(FoodItemdto foodItemdto);
    String updateItem(Long id, FoodItem newFoodItem);
    List<FoodItem> allItems();
    List<FoodItem> getItembycategory(String category);
}
