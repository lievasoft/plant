package org.lievasoft.nursery.dto;

import jakarta.validation.constraints.NotBlank;
import org.lievasoft.nursery.enums.Status;

public record PlantCreateRequestDto(
        @NotBlank(message = "common name is required")
        String commonName,
        String familyId,
        Status status
) {
}
