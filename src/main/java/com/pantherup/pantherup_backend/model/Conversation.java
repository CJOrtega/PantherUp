package com.pantherup.pantherup_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import com.pantherup.pantherup_backend.model.Message;

import java.awt.*;
import java.util.List;
import java.time.LocalDate;

//used for messaging
@Data
@Entity
public class Conversation {
    @Id
    @GeneratedValue
    private Long conversationId;
    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL)
    private List<Message> messages;
    private List<Long> participants;
    private LocalDate lastMessageDate;
    //To Implement
    //private List<image> images;
}
