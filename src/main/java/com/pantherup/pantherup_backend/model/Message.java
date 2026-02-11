package com.pantherup.pantherup_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

//will have a relationship with Conversation
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long messageId;
    LocalDateTime date = LocalDateTime.now();
    String message;
    private Long senderId;
}
