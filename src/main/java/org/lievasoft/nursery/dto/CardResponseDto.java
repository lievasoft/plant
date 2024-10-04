package org.lievasoft.nursery.dto;

import org.lievasoft.nursery.enums.Status;

public record CardResponseDto(
        Long id,
        String commonName,
        Status status,
        String imageId
) {
}
