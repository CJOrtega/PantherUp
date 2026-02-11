package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Listing;

import java.util.List;

public interface ListingService {

    Listing createListing(Listing listing);
    List<Listing> getAllListings();
    Listing getListingById(Long listingId);
    void updateListing(Long listingId, Listing listing);
    void deleteListing(Long listingId);
}
