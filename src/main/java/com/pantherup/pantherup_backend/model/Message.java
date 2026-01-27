package com.pantherup.pantherup_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//will have a relationship with Conversation
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
}
