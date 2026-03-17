package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.User;
import com.pantherup.pantherup_backend.repository.UserRepository;
import com.pantherup.pantherup_backend.security.jwt.JwtUtils;
import com.pantherup.pantherup_backend.security.request.LoginRequest;
import com.pantherup.pantherup_backend.security.request.SignupRequest;
import com.pantherup.pantherup_backend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public void registerUser(SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername()) ||
                userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Username or Email already exists");
        }

        User user = new User(signupRequest.getUsername(),
                            signupRequest.getEmail(),
                            passwordEncoder.encode(signupRequest.getPassword()));

        userRepository.save(user);
    }

    public ResponseCookie authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return jwtUtils.generateJwtCookie(userDetails);
    }
}
