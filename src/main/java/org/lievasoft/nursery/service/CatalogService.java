package org.lievasoft.nursery.service;

import org.lievasoft.nursery.dto.CardResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CatalogService {

    Page<CardResponseDto> obtainPlantCards(Pageable pageable);
}
