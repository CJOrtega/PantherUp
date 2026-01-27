package com.pantherup.pantherup_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//used for messaging
@Entity
public class Conversation {
    @Id
    @GeneratedValue
    private Long id;
}
