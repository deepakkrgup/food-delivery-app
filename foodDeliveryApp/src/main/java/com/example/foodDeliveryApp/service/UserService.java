package com.example.foodDeliveryApp.service;

import java.util.*;
import com.example.foodDeliveryApp.dto.Userdto;
import com.example.foodDeliveryApp.entity.User;

public interface UserService {
    String registerUser(Userdto userdto);
    String userLogin(Userdto userdto);
    List<User> getUser();
    String deleteUser(Long id);
    String updateUser(Long id, User newUserdetails);
}
