package org.lievasoft.nursery.plant.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lievasoft.nursery.plant.*;
import org.lievasoft.nursery.plant.dtos.PlantCreateRequestDto;
import org.lievasoft.nursery.plant.dtos.PlantCreateResponseDto;
import org.lievasoft.nursery.plant.entities.Plant;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantMapper mapper;
    private final PlantRepository repository;

    @Override
    public PlantCreateResponseDto create(final PlantCreateRequestDto request) {
        Plant plantMapped = mapper.toPlant(request);
        Plant plantPersisted = repository.save(plantMapped);
        log.info("Plant persisted with Id: {}", plantPersisted.getId());
        return mapper.fromPlant(plantPersisted);
    }
}
