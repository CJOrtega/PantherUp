package com.pantherup.pantherup_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pantherup.pantherup_backend.model.Message;
import com.pantherup.pantherup_backend.service.MessageServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageServiceImplementation messageService;

    public MessageController(MessageServiceImplementation messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Message createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateMessage(@PathVariable Long id, @RequestBody Message message) {
        messageService.updateMessage(id, message);
    }
}
