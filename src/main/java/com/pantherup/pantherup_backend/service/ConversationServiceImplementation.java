package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Conversation;
import com.pantherup.pantherup_backend.repository.ConversationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationServiceImplementation implements ConversationService{
    private final ConversationRepository conversationRepository;

    public Conversation createConversation(Conversation conversation){
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getAllConversations(){
        return conversationRepository.findAll();
    }

    public Conversation getConversationById(Long conversationId){
        return conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation not found"));
    }

    public void updateConversation(Long conversationId, Conversation conversation){
        if(!conversationRepository.existsById(conversationId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation not found");
        }
        conversationRepository.save(conversation);
    }

    public void deleteConversation(Long conversationId){
        if(!conversationRepository.existsById(conversationId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation not found");
        }
        conversationRepository.deleteById(conversationId);
    }
}
