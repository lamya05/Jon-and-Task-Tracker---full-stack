package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // SIGNUP ENDPOINT
    @PostMapping("/signup")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
public String loginUser(@RequestBody User loginData) {
   
    Optional<User> user = userRepository.findByEmail(loginData.getEmail());
    
    if (user.isPresent()) {
        
        if (user.get().getPassword().equals(loginData.getPassword())) {
            return "Login Success";
        } else {
            return "Wrong Password";
        }
    } else {
        return "User Not Found";
    }
}
}