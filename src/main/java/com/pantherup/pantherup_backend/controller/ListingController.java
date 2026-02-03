package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.Listing;
import com.pantherup.pantherup_backend.repository.ListingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/listing")
public class ListingController {
    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }
    @GetMapping("")
    public List<Listing> listAll(){
        return listingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Listing findById(@PathVariable Long id){
        return listingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Listing not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Listing listing){
        listingRepository.save(listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Listing listing){
        if (!listingRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Listing not found");
        }
        listingRepository.save(listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if (!listingRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Listing not found");
        }
        listingRepository.deleteById(id);
    }

}
