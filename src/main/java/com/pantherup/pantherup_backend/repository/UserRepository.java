package com.pantherup.pantherup_backend.repository;

import com.pantherup.pantherup_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// This interface connects your User model to the database
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}