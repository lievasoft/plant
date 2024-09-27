package org.lievasoft.nursery.plant.dto;

import org.lievasoft.nursery.plant.enums.Status;

public record PlantCreateResponseDto(
        Long id,
        String commonName,
        Status status
) {
}
