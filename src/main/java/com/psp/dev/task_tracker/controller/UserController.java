package com.psp.dev.task_tracker.controller;

import com.psp.dev.task_tracker.dto.LoginRequestDTO;
import com.psp.dev.task_tracker.model.User;
import com.psp.dev.task_tracker.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody User user) {

        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body("Email is already taken");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        // Log input values
        System.out.println("Username: " + loginRequestDTO.getUsername());
        System.out.println("Password: " + loginRequestDTO.getPassword());

        // Find user by username
        Optional<User> userOptional = userRepository.findByUsername(loginRequestDTO.getUsername());

        // Check if user exists
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Incorrect username or password");
        }

        // Verify password
        if (!bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(), userOptional.get().getPassword())) {
            return ResponseEntity.badRequest().body("Incorrect username or password");
        }

        // Success
        return ResponseEntity.ok("Login successful");
    }

}
