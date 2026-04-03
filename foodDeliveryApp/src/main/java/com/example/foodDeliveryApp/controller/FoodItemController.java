package com.example.foodDeliveryApp.controller;

import java.util.*;
import com.example.foodDeliveryApp.dto.FoodItemdto;
import com.example.foodDeliveryApp.entity.FoodItem;
import com.example.foodDeliveryApp.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/fooditem")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping("/itemname")
    public String itemName(@RequestBody FoodItemdto foodItemdto)
    {
        return foodItemService.addFoodItem(foodItemdto);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody FoodItem newFoodItem)
    {
        return foodItemService.updateItem(id, newFoodItem);
    }
    @GetMapping
    public List<FoodItem> getAllItems()
    {
        return foodItemService.allItems();
    }

    @GetMapping("/bycat/{category}")
    public List<FoodItem> getByCategory(@PathVariable String category)
    {
        return  foodItemService.getItembycategory(category);
    }
}
