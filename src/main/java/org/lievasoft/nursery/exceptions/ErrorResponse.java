package org.lievasoft.nursery.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        String path,
        String reason,
        LocalDateTime timestamp
) {
}
