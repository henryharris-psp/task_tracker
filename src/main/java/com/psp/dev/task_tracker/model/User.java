package com.psp.dev.task_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is required...")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password is required...")
    @Column(name = "password")
    private String password;

    @NotNull(message = "First Name is required...")
    @Column(name = "firstname")
    private String firstName;

    @NotNull(message = "Last Name is required...")
    @Column(name = "lastname")
    private String lastName;

    @NotNull(message = "Email is required...")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Phone number is required...")
    @Column(name = "phone")
    private String phone;

    @NotNull(message = "Address is required...")
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;


}
