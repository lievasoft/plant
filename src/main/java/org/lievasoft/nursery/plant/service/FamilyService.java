package org.lievasoft.nursery.plant.service;

import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;

import java.util.List;

public interface FamilyService {

    FamilyResponseDto create(FamilyCreateRequestDto request);

    List<FamilyResponseDto> findAll();
}
