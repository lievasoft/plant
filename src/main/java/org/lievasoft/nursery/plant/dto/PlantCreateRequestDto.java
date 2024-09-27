package org.lievasoft.nursery.plant.dto;

import jakarta.validation.constraints.NotBlank;
import org.lievasoft.nursery.plant.enums.Status;

public record PlantCreateRequestDto(
        @NotBlank(message = "common name is required")
        String commonName,
        String familyId,
        @NotBlank(message = "status is required")
        Status status
) {
}
