package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.Listing;
import com.pantherup.pantherup_backend.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ListingController {
    /**
     * POST   /api/listings
     * GET    /api/listings
     * GET    /api/listings/{listingId}
     * PUT    /api/listings/{listingId}
     * DELETE /api/listings/{listingId}
     * --------------------------------------------
     * Purpose:
     * Create a listing
     * Retrieve listings
     * Retrieve a single listing
     * Update an existing listing
     * Remove a listing
     */

    private final ListingService listingService;

    @PostMapping("/listings")
    public Listing createListing(@RequestBody Listing listing) {
        Listing listingCreated = listingService.createListing(listing);
        return listingCreated;
    }
}
