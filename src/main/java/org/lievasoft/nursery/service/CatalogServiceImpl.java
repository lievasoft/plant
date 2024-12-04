package org.lievasoft.nursery.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCardDto;
import org.lievasoft.nursery.dto.PlantFeaturesDto;
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
    public Page<PlantCardDto> obtainPlantCards(Pageable pageable) {
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;
        List<PlantCardDto> plantsMapped = plantJpaRepository.findAllPlantCardByPagination(limit, offset);
        return new PageImpl<>(plantsMapped, pageable, plantJpaRepository.count());
    }

    @Override
    public PlantFeaturesDto obtainPlantFeatures(Long plantId) {
        Plant plantObtained = plantJpaRepository.findById(plantId)
                .orElseThrow(() -> new EntityNotFoundException("Plant with id " + plantId + " not found"));


        return null;
    }
}
