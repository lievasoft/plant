package org.lievasoft.nursery.service;

import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.dto.CardResponseDto;
import org.lievasoft.nursery.repository.ImageJpaRepository;
import org.lievasoft.nursery.repository.PlantJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final PlantJpaRepository plantJpaRepository;
    private final ImageJpaRepository imageJpaRepository;

    @Override
    public Page<CardResponseDto> obtainPlantCards(Pageable pageable) {
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;

        List<PlantCardResponseDTO> plantsMapped =
                plantJpaRepository.findAllPlantCards(limit, offset)
                .stream()
                .map(this::toPlantCardResponseDTO)
                        .collect(Collectors.toCollection(ArrayList::new));

        return null;
    }
}
