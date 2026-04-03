package com.example.foodDeliveryApp.controller;

import com.example.foodDeliveryApp.dto.Userdto;
import com.example.foodDeliveryApp.entity.User;
import com.example.foodDeliveryApp.repository.UserRepository;
import com.example.foodDeliveryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody Userdto userdto)
    {
        return userService.registerUser(userdto);
    }

    @PostMapping("/login")
    public String login(@RequestBody Userdto userdto)
    {
        return userService.userLogin(userdto);
    }

    @GetMapping
    public List<User> getAllUser()
    {
        return userService.getUser();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody User newUserdetails)
    {
        return userService.updateUser(id, newUserdetails);
    }
}
