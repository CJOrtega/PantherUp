package com.pantherup.pantherup_backend.controller;

import com.pantherup.pantherup_backend.model.Image;
import com.pantherup.pantherup_backend.service.ImageService;
import com.pantherup.pantherup_backend.service.ImageServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageServiceImplementation imageService) {
        this.imageService = imageService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Image createImage(@RequestBody Image image) {
        return imageService.createImage(image);
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Image image) {
        imageService.updateImage(id, image);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}