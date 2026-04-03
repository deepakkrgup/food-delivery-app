package com.example.foodDeliveryApp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Userdto {
    private String name;
    private String email;
    private String password;
    private String address;
}
