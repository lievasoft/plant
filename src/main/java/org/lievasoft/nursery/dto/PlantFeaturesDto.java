package org.lievasoft.nursery.dto;

import org.lievasoft.nursery.enums.Classification;
import org.lievasoft.nursery.enums.Status;

import java.time.LocalDateTime;
import java.util.Set;

public record PlantFeaturesDto(
    Long id,
    String commonName,
    String scientificName,
    Status status,
    Set<Classification> classifications,
    String familyName,
    Double price,
    LocalDateTime createAt,
    LocalDateTime lastModifiedAt,
    String imageId,
    String description,
    TechnicalSheet technicalSheet
) {
}
