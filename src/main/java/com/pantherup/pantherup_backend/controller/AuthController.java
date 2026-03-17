package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.security.jwt.JwtUtils;
import com.pantherup.pantherup_backend.security.request.LoginRequest;
import com.pantherup.pantherup_backend.security.request.SignupRequest;
import com.pantherup.pantherup_backend.security.response.MessageResponse;
import com.pantherup.pantherup_backend.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//This controller will handle authenticating users
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    private JwtUtils jwtUtils;

    //accept a signup request
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        authService.registerUser(signupRequest);
        MessageResponse messageResponse = new MessageResponse("User successfully created");
        return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.CREATED);
    }

    //accept a login request and authenticate the user
    @PostMapping("/login")
    public ResponseEntity<?> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {
        ResponseCookie jwtCookie = authService.authenticateUser(loginRequest);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.getValue())
                .body(new MessageResponse("User successfully logged in"));
    }

    //make the session expire and logout the user
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
