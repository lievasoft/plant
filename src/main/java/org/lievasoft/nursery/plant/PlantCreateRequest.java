package org.lievasoft.nursery.plant;

import jakarta.validation.constraints.NotBlank;

public record PlantCreateRequest(
        @NotBlank(message = "common name is required")
        String commonName
) {
}
