package org.lievasoft.nursery.plant.services;

import org.lievasoft.nursery.plant.dtos.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dtos.PlantCreateResponseDto;

public interface PlantService {

    PlantCreateResponseDto create(PlantCreateRequestDto request);
}
