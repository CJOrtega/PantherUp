package com.pantherup.pantherup_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Data
@Entity
public class Image {
    @Id
    @GeneratedValue
    private Long imageId;
    private String storageKey;
    String contentType;
    Long sizeBytes;
    String url;
    Integer width;
    Integer height;
    Boolean isPrimary;
    @ManyToOne
    @JoinColumn(name = "listing_id")
    private Listing listing;
    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;
}
