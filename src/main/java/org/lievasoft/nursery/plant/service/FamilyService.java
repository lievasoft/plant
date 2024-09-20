package org.lievasoft.nursery.plant.service;

import org.lievasoft.nursery.plant.domain.Family;
import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;

import java.util.List;
import java.util.Optional;

public interface FamilyService {

    FamilyResponseDto create(FamilyCreateRequestDto request);

    List<FamilyResponseDto> findAll();
}
