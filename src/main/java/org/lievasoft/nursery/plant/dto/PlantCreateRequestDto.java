package org.lievasoft.nursery.plant.dto;

import jakarta.validation.constraints.NotBlank;

public record PlantCreateRequestDto(
        @NotBlank(message = "common name is required")
        String commonName
) {
}
