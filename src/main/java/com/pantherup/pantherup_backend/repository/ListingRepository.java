package com.pantherup.pantherup_backend.repository;

import com.pantherup.pantherup_backend.model.Listing;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ListingRepository extends ListCrudRepository<Listing,Long>{
   Optional<Listing> findByPrice(Integer price);
}