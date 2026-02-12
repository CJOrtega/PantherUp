package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.User;
import com.pantherup.pantherup_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    //Constructor Injection
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Create new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return  ResponseEntity.ok(createdUser);
    }

    //Get all users
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserbyId(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserbyEmail (@PathVariable String email){
        Optional<User> user = userService.getUserByEmail(email);

        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
