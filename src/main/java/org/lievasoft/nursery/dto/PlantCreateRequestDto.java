package org.lievasoft.nursery.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.lievasoft.nursery.enums.Classification;
import org.lievasoft.nursery.enums.Status;

import java.math.BigDecimal;
import java.util.Set;

public record PlantCreateRequestDto(
        @NotBlank(message = "common name is required")
        String commonName,
        String scientificName,
        Status status,
        Set<Classification> classifications,
        String familyId,
        @Positive(message = "price must be positive")
        BigDecimal price,
        String description,
        String origin,
        String size,
        String flowering,
        String location,
        String soil,
        String fertilization,
        String pruning,
        String propagation
) {
}
