package org.lievasoft.nursery.dto;

import org.lievasoft.nursery.enums.Classification;
import org.lievasoft.nursery.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record PlantResponseDto(
        Long id,
        String commonName,
        String scientificName,
        Status status,
        Set<Classification> classifications,
        String familyId,
        BigDecimal price,
        LocalDateTime createdAt,
        LocalDateTime lastModifiedAt
) {
}
