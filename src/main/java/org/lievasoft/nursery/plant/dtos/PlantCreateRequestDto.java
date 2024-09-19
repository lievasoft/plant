package org.lievasoft.nursery.plant.dtos;

import jakarta.validation.constraints.NotBlank;

public record PlantCreateRequestDto(
        @NotBlank(message = "common name is required")
        String commonName
) {
}
