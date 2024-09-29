package org.lievasoft.nursery.dto;

import jakarta.validation.constraints.NotBlank;

public record FamilyCreateRequestDto(
        @NotBlank(message = "family name is required")
        String name
) {
}
