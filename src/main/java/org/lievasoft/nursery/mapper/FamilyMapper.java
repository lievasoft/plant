package org.lievasoft.nursery.mapper;

import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.dto.FamilyResponseDto;
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
