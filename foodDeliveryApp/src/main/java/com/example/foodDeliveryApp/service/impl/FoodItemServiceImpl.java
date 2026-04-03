package com.example.foodDeliveryApp.service.impl;

import com.example.foodDeliveryApp.dto.FoodItemdto;
import com.example.foodDeliveryApp.entity.FoodItem;
import com.example.foodDeliveryApp.repository.FoodItemRepository;
import com.example.foodDeliveryApp.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public String addFoodItem(FoodItemdto foodItemdto)
    {
        FoodItem foodItem = new FoodItem();
        foodItem.setName(foodItemdto.getName());
        foodItem.setPrice(foodItemdto.getPrice());
        foodItem.setDescription(foodItemdto.getDescription());
        foodItem.setCategory(foodItemdto.getCategory());

        foodItemRepository.save(foodItem);
        return "item added successfully";
    }

    @Override
    public String updateItem(Long id,FoodItem newFoodItem)
    {
        Optional<FoodItem> existItem = foodItemRepository.findById(id);
        if(existItem.isPresent())
        {
            FoodItem foodItem = foodItemRepository.findById(id).get();
            foodItem.setCategory(newFoodItem.getCategory());
            foodItem.setName(newFoodItem.getName());
            foodItem.setDescription(newFoodItem.getDescription());
            foodItem.setPrice(newFoodItem.getPrice());
            foodItemRepository.save(foodItem);
            return "food item updated successfully";
        }
        else {
            return "Item not found";
        }
    }

    @Override
    public List<FoodItem> allItems()
    {
        return foodItemRepository.findAll();
    }

    @Override
    public List<FoodItem> getItembycategory(String category)
    {
        return foodItemRepository.findByCategory(category);

    }
}
