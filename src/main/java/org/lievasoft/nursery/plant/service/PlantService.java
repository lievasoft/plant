package org.lievasoft.nursery.plant.service;

import org.lievasoft.nursery.plant.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dto.PlantCreateResponseDto;

public interface PlantService {

    PlantCreateResponseDto create(PlantCreateRequestDto request);
}
