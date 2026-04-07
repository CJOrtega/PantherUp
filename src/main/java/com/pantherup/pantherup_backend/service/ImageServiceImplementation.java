package com.pantherup.pantherup_backend.service;

import com.pantherup.pantherup_backend.model.Image;
import com.pantherup.pantherup_backend.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ImageServiceImplementation implements ImageService{
    private final ImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Image getImageById(Long imageId) {
        return imageRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));
    }

    public void updateImage(Long imageId, Image image) {
        if (!imageRepository.existsById(imageId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
        }
        imageRepository.save(image);
    }

    public void deleteImage(Long imageId) {
        if (!imageRepository.existsById(imageId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
        }
        imageRepository.deleteById(imageId);
    }
}
