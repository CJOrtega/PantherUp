package com.pantherup.pantherup_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Listing {
    @Id
    @GeneratedValue
    private Long id;
}
