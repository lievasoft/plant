package org.lievasoft.nursery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.lievasoft.nursery.service.PlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plants")
public class PlantController {

    private final PlantService plantService;

    @PostMapping
    public ResponseEntity<PlantCreateResponseDto> create(@RequestBody @Valid PlantCreateRequestDto request) {
        return ResponseEntity
                .created(URI.create("/api/v1/plants"))
                .body(plantService.create(request));
    }

    @PostMapping(value = "/{plantId}/image", consumes = {"multipart/form-data"})
    public ResponseEntity<Void> uploadImage(@PathVariable("plantId") Long plantId, @RequestPart("image") MultipartFile file) {
        plantService.uploadImageToFileSystem(plantId, file);
        return ResponseEntity.ok().build();
    }
}
