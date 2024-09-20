package org.lievasoft.nursery.plant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;
import org.lievasoft.nursery.plant.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<FamilyResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
