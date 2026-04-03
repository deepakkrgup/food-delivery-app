package com.example.foodDeliveryApp.controller;

import com.example.foodDeliveryApp.dto.Orderdto;
import com.example.foodDeliveryApp.entity.Orders;
import com.example.foodDeliveryApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<Orders> createOrder(@RequestBody Orderdto orderdto)
    {
        Orders savedOrder = orderService.placeOrder(orderdto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
