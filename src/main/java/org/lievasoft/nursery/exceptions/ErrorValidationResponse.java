package org.lievasoft.nursery.exceptions;

import java.util.Map;

public record ErrorValidationResponse(
        Map<String, String> errors
) {
}
