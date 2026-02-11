package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Listing;
import com.pantherup.pantherup_backend.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingServiceImplementation implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }

    public Listing getListingById(Long listingId) {
        return listingRepository.findById(listingId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found"));
    }

    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    public void updateListing(Long listingId, Listing listing) {
        if (!listingRepository.existsById(listingId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found");
        }
        listingRepository.save(listing);
    }

    public void deleteListing(Long listingId) {
        if (!listingRepository.existsById(listingId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Listing not found");
        }
        listingRepository.deleteById(listingId);
    }
}