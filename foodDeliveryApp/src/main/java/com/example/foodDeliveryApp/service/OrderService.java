package com.example.foodDeliveryApp.service;

import com.example.foodDeliveryApp.dto.Orderdto;
import com.example.foodDeliveryApp.entity.Orders;

public interface OrderService {
    Orders placeOrder(Orderdto orderdto);
}
