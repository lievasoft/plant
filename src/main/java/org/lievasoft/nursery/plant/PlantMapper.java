package org.lievasoft.nursery.plant;

import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public Plant toPlant(final PlantCreateRequest request) {
        return Plant.builder()
                .commonName(request.commonName())
                .build();
    }
}
