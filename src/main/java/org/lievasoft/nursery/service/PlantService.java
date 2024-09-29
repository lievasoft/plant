package org.lievasoft.nursery.service;

import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;

public interface PlantService {

    PlantCreateResponseDto create(PlantCreateRequestDto request);
}
