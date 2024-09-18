package org.lievasoft.nursery.plant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantMapper mapper;
    private final PlantRepository repository;

    @Override
    public String create(final PlantCreateRequest request) {
        Plant plantMapped = mapper.toPlant(request);
        Plant plantPersisted = repository.save(plantMapped);
        log.info("Plant persisted with Id: {}", plantPersisted.getId());
        return plantPersisted.getId();
    }
}
