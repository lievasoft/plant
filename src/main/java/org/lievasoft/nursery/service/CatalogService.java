package org.lievasoft.nursery.service;

import org.lievasoft.nursery.dto.PlantCardDto;
import org.lievasoft.nursery.dto.PlantFeaturesDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CatalogService {

    Page<PlantCardDto> obtainPlantCards(Pageable pageable);

    PlantFeaturesDto obtainPlantFeatures(Long plantId);
}
