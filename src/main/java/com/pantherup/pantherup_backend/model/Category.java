package com.pantherup.pantherup_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//to sort listings by category (optional)
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
}
