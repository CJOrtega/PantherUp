package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.security.request.LoginRequest;
import com.pantherup.pantherup_backend.security.request.SignupRequest;
import org.springframework.http.ResponseCookie;

public interface AuthService {
    public void registerUser(SignupRequest signupRequest);
    public ResponseCookie authenticateUser(LoginRequest loginRequest);
}
