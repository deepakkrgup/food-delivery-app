package com.example.foodDeliveryApp.service.impl;

import com.example.foodDeliveryApp.dto.Userdto;
import com.example.foodDeliveryApp.entity.User;
import com.example.foodDeliveryApp.repository.UserRepository;
import com.example.foodDeliveryApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(Userdto userdto)
    {
        User user = new User();
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        //user.setPassword(userdto.getPassword());
        user.setAddress(userdto.getAddress());
        user.setVerified(true);
        String encodedPassword = passwordEncoder.encode(userdto.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "User registered successfully";
    }

    @Override
    public String userLogin(Userdto userdto) {
        User user = userRepository.findByEmail(userdto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
//        if (userdto.getPassword().equals(user.getPassword())) {
//            return "Login Successfully (Plain Text Match)";
//        } else {
//            return "Invalid Password! Database mein '" + user.getPassword() + "' hai aur aapne '" + userdto.getPassword() + "' bheja hai.";
//        }
        if (passwordEncoder.matches(userdto.getPassword(), user.getPassword())) {

            // Verification check (Jo aapne pucha tha)
//            if (!user.isVerified()) {
//                return "Login Failed: Pehle account verify karein!";
//            }
//
            return "Login Successfully";
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
    @Override
    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long id)
    {
        userRepository.deleteById(id);
        return "user deleted successfully";
    }

    @Override
    public String updateUser(Long id, User newUserdetails)
    {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            User user = userRepository.findById(id).get();
            user.setEmail(newUserdetails.getEmail());
            user.setName(newUserdetails.getName());
            user.setAddress(newUserdetails.getAddress());
            user.setPassword(newUserdetails.getPassword());
            userRepository.save(user);
            return "user detailed updated successfully";
        }
        else
        {
            return "User with ID "+id+" does not exist.";
        }
    }
}
