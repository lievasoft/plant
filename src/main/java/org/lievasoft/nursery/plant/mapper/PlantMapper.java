package org.lievasoft.nursery.plant.mapper;

import org.lievasoft.nursery.plant.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dto.PlantCreateResponseDto;
import org.lievasoft.nursery.plant.domain.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public Plant toPlant(final PlantCreateRequestDto request) {
        return Plant.builder()
                .commonName(request.commonName())
                .build();
    }

    public PlantCreateResponseDto fromPlant(final Plant plant) {
        return new PlantCreateResponseDto(plant.getId(), plant.getCommonName());
    }
}
