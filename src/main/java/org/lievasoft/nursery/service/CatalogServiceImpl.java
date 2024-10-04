package org.lievasoft.nursery.service;

import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.dto.CardResponseDto;
import org.lievasoft.nursery.repository.PlantJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final PlantJpaRepository plantJpaRepository;

    @Override
    public Page<CardResponseDto> obtainPlantCards(Pageable pageable) {
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        List<CardResponseDto> plantsMapped = plantJpaRepository.findAllPlantCardByPagination(limit, offset);
        return new PageImpl<>(plantsMapped, pageable, plantJpaRepository.count());
    }
}
