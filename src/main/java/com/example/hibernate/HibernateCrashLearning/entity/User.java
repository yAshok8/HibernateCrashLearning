package com.example.hibernate.HibernateCrashLearning.entity;

import javax.persistence.*;

@Entity(name="app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    private String username;
    private String email;

    // Constructors, getters, and setters

    // You can generate these using your IDE or manually write them.
}
