package org.lievasoft.nursery.plant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;
import org.lievasoft.nursery.plant.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/families")
public class FamilyController {

    private final FamilyService service;

    @PostMapping
    public ResponseEntity<FamilyResponseDto> create(@RequestBody @Valid FamilyCreateRequestDto request) {
        return ResponseEntity
                .created(URI.create("/api/v1/families"))
                .body(service.create(request));
    }
}
