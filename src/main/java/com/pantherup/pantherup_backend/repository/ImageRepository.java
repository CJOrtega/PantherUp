package com.pantherup.pantherup_backend.repository;

import com.pantherup.pantherup_backend.model.Image;
import org.springframework.data.repository.ListCrudRepository;

public interface ImageRepository extends ListCrudRepository<Image,Long> {
}
