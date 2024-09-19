package org.lievasoft.nursery.plant;

import org.lievasoft.nursery.plant.dtos.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dtos.PlantCreateResponseDto;
import org.lievasoft.nursery.plant.entities.Plant;
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
