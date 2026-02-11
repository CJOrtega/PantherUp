package com.pantherup.pantherup_backend.repository;

import com.pantherup.pantherup_backend.model.Message;
import org.springframework.data.repository.ListCrudRepository;

public interface MessageRepository extends ListCrudRepository<Message,Long>{
}
