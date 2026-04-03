package com.example.foodDeliveryApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "mendatory name")
    private String name;

    @Email(message = "mendatory email")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank(message = "fill it")
    private String address;

    private boolean isVerified = false;

}
