package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.Listing;
import com.pantherup.pantherup_backend.service.ListingServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/listing")
public class ListingController {
    private final ListingServiceImplementation listingService;

    public ListingController(ListingServiceImplementation listingService) {
        this.listingService = listingService;
    }

    @GetMapping("")
    public List<Listing> listAll() {
        return listingService.getAllListings();
    }

    @GetMapping("/{id}")
    public Listing findById(@PathVariable Long id) {
        return listingService.getListingById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Listing listing) {
        listingService.createListing(listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Listing listing) {
        listingService.updateListing(id, listing);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    listingService.deleteListing(id);}
}
