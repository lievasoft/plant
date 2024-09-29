package org.lievasoft.nursery.service;

import org.lievasoft.nursery.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.dto.FamilyResponseDto;

import java.util.List;

public interface FamilyService {

    FamilyResponseDto create(FamilyCreateRequestDto request);

    List<FamilyResponseDto> findAll();
}
