package org.lievasoft.nursery.mapper;

import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public Plant toPlant(final PlantCreateRequestDto request, final Family family) {
        return Plant.builder()
                .commonName(request.commonName())
                .status(request.status())
                .classifications(request.classifications())
                .family(family)
                .description(request.description())
                .price(request.price())
                .build();
    }

    public PlantCreateResponseDto fromPlant(final Plant plant) {
        String familyId = plant.getFamily() != null ? plant.getFamily().getId() : null;
        return new PlantCreateResponseDto(
                plant.getId(),
                plant.getCommonName(),
                plant.getStatus(),
                plant.getClassifications(),
                familyId,
                plant.getPrice(),
                plant.getCreatedAt(),
                plant.getLastModifiedAt()
        );
    }
}
