package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.Conversation;
import com.pantherup.pantherup_backend.service.ConversationServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversation")
public class ConversationController {
    private final ConversationServiceImplementation conversationService;

    public ConversationController(ConversationServiceImplementation conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("")
    public List<Conversation> listAll() {
        return conversationService.getAllConversations();
    }

    @GetMapping("/{id}")
    public Conversation findById(@PathVariable Long id) {
        return conversationService.getConversationById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Conversation create(@RequestBody Conversation conversation) {
        return conversationService.createConversation(conversation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Conversation conversation) {
        conversationService.updateConversation(id, conversation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        conversationService.deleteConversation(id);
    }
}
