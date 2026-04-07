package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Conversation;

import java.util.List;
public interface ConversationService {

    Conversation createConversation(Conversation conversation);
    List<Conversation> getAllConversations();
    Conversation getConversationById(Long conversationId);
    void deleteConversation(Long conversationId);
    void updateConversation(Long conversationId, Conversation conversation);
}
