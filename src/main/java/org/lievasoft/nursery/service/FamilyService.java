package org.lievasoft.nursery.service;

import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.dto.FamilyResponseDto;

import java.util.List;
import java.util.Set;

public interface FamilyService {

    FamilyResponseDto create(FamilyCreateRequestDto request);

    List<FamilyResponseDto> findAll();

    Family findById(String id);

    List<FamilyResponseDto> createMany(Set<FamilyCreateRequestDto> payload);
}
