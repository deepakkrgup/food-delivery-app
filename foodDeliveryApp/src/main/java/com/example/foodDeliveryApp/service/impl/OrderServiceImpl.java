package com.example.foodDeliveryApp.service.impl;

import com.example.foodDeliveryApp.dto.Orderdto;
import com.example.foodDeliveryApp.entity.FoodItem;
import com.example.foodDeliveryApp.entity.Orders;
import com.example.foodDeliveryApp.repository.FoodItemRepository;
import com.example.foodDeliveryApp.repository.OrderRepository;
import com.example.foodDeliveryApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public Orders placeOrder(Orderdto orderdto)
    {
        Orders orders = new Orders();
        orders.setUserId(orderdto.getUserId());
        orders.setFoodItemId(orderdto.getFoodItemId());
        orders.setQuantity(orderdto.getQuantity());

        FoodItem food = foodItemRepository.findById(orderdto.getFoodItemId())
                .orElseThrow(() -> new RuntimeException("Food item nahi mila!"));

        int calculatedTotal = food.getPrice() * orderdto.getQuantity();
        orders.setTotalPrice(calculatedTotal);
        return orderRepository.save(orders);
    }
}
