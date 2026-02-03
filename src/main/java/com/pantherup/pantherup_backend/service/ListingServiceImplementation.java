package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Listing;
import com.pantherup.pantherup_backend.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingServiceImplementation implements ListingService {

    private final ListingRepository listingRepository;

    @Override
    public Listing createListing(Listing listing) {
        return listingRepository.save(listing);
    }
}
