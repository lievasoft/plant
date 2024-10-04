package org.lievasoft.nursery.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.dto.FamilyResponseDto;
import org.lievasoft.nursery.service.FamilyService;
import org.lievasoft.nursery.utils.ValidSet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/families")
public class FamilyController {

    private final FamilyService service;

    @PostMapping("/batch")
    public ResponseEntity<List<FamilyResponseDto>> createMany(@RequestBody @Valid ValidSet<FamilyCreateRequestDto> payload) {
        return ResponseEntity
                .created(URI.create("/api/v1/families/batch"))
                .body(service.createMany(payload));
    }

    @GetMapping
    public ResponseEntity<List<FamilyResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
