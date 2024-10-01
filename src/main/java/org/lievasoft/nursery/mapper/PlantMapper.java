package org.lievasoft.nursery.mapper;

import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.domain.Information;
import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public Plant toPlant(final PlantCreateRequestDto request, final Family family) {
        Information information = Information.builder()
                .description(request.description())
                .origin(request.origin())
                .size(request.size())
                .flowering(request.flowering())
                .location(request.location())
                .soil(request.soil())
                .fertilization(request.fertilization())
                .pruning(request.pruning())
                .propagation(request.propagation())
                .build();

        return Plant.builder()
                .commonName(request.commonName())
                .status(request.status())
                .classifications(request.classifications())
                .family(family)
                .price(request.price())
                .information(information)
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
