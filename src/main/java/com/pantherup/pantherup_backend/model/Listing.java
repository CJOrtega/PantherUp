package com.pantherup.pantherup_backend.model;

import com.pantherup.pantherup_backend.config.Status;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Data
@Entity
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingId;
    private Long userId;
    Double price;
    String listingTitle;
    String listingDescription;
    String listingImagesId;
    @Enumerated(EnumType.STRING)
    Status status;
    LocalDate listingDate;

}
