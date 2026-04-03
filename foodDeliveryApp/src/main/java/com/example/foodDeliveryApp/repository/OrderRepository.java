package com.example.foodDeliveryApp.repository;

import com.example.foodDeliveryApp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
