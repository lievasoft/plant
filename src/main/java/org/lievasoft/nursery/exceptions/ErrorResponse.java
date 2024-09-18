package org.lievasoft.nursery.exceptions;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
