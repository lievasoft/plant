package org.lievasoft.nursery.plant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.plant.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dto.PlantCreateResponseDto;
import org.lievasoft.nursery.plant.service.PlantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
