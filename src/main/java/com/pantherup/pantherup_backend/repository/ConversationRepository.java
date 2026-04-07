package com.pantherup.pantherup_backend.repository;

import com.pantherup.pantherup_backend.model.Conversation;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ConversationRepository extends ListCrudRepository<Conversation,Long>{
}

