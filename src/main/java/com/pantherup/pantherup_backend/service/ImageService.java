package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Image;

public interface ImageService {
    Image createImage(Image image);
    Image getImageById(Long imageId);
    void deleteImage(Long imageId);
    void updateImage(Long imageId, Image image);
}
