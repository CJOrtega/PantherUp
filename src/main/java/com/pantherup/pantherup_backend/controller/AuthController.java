package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.security.request.LoginRequest;
import com.pantherup.pantherup_backend.security.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller will handle authenticating users
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    //accept a signup request
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        return null;
    }

    //accept a login request and authenticate the user
    @PostMapping("/login")
    public ResponseEntity<?> loginRequest(LoginRequest loginRequest) {
        return null;
    }

    //get the current user
    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        return null;
    }

    //make the session expire and logout the user
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return null;
    }
}
