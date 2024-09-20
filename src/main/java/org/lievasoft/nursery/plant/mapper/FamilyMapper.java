package org.lievasoft.nursery.plant.mapper;

import org.lievasoft.nursery.plant.domain.Family;
import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FamilyMapper {

    public Family toFamily(FamilyCreateRequestDto dto) {
        return Family.builder()
                .name(dto.name())
                .build();
    }

    public FamilyResponseDto fromFamily(Family family) {
        return new FamilyResponseDto(family.getId(), family.getName());
    }
}
