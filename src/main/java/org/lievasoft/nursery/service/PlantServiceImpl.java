package org.lievasoft.nursery.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.lievasoft.nursery.mapper.PlantMapper;
import org.lievasoft.nursery.repository.FamilyRepository;
import org.lievasoft.nursery.repository.PlantRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantMapper mapper;
    private final PlantRepository repository;
    private final FamilyRepository familyRepository;

    @Override
    public PlantCreateResponseDto create(final PlantCreateRequestDto request) {
        Family familyObtained = null;
        if (request.familyId() != null) {
            familyObtained = familyRepository.findById(request.familyId())
                    .orElseThrow(() -> {
                        String msg = String.format("Family with Id: %s does not exists when we are creating a plant", request.familyId());
                        log.warn(msg);
                        return new EntityNotFoundException(msg);
                    });
        }

        Plant plantMapped = mapper.toPlant(request, familyObtained);
        Plant plantPersisted = repository.save(plantMapped);
        log.info("Plant persisted with Id: {}", plantPersisted.getId());
        return mapper.fromPlant(plantPersisted);
    }
}
