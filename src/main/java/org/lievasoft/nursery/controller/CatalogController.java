package org.lievasoft.nursery.controller;

import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.dto.PlantCardDto;
import org.lievasoft.nursery.dto.PlantFeaturesDto;
import org.lievasoft.nursery.service.CatalogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    private final CatalogService service;

    @GetMapping
    public ResponseEntity<Page<PlantCardDto>> fetchPlantCards(@PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok(service.obtainPlantCards(pageable));
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<PlantFeaturesDto> fetchPlantFeatures(@PathVariable Long plantId) {
        return ResponseEntity.ok(service.obtainPlantFeatures(plantId));
    }
}
