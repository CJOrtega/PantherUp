package com.pantherup.pantherup_backend.model;

import com.pantherup.pantherup_backend.config.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listingId;
    private Long userId;
    Integer price;
    String listingTitle;
    String listingDescription;
    String listingImagesId;
    @Enumerated(EnumType.STRING)
    Status status;
    LocalDate listingDate;

}
