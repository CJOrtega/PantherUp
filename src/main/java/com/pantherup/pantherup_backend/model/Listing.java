package com.pantherup.pantherup_backend.model;

import com.pantherup.pantherup_backend.config.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.time.LocalDate;

@Entity
public class Listing {
    @Id
    @GeneratedValue
    private Long listingId;
    @JoinColumn
    private Long userId;
    Integer price;
    String listingTitle;
    String listingDescription;
    String listingImagesId;
    Status status;
    LocalDate listingDate;

}
