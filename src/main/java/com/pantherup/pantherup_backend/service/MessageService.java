package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Message message);
    Message getMessageById(Long messageId);
    void deleteMessage(Long messageId);
    void updateMessage(Long messageId, Message message);
}
