package org.lievasoft.nursery.plant.service;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lievasoft.nursery.plant.domain.Family;
import org.lievasoft.nursery.plant.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.plant.dto.FamilyResponseDto;
import org.lievasoft.nursery.plant.mapper.FamilyMapper;
import org.lievasoft.nursery.plant.repository.FamilyRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService{

    private final FamilyMapper mapper;
    private final FamilyRepository repository;

    @Override
    public FamilyResponseDto create(final FamilyCreateRequestDto request) {
        if (repository.existsByName(request.name())) {
            String msg = String.format("family with name %s already exists", request.name());
            log.warn(msg);
            throw new EntityExistsException(msg);

        } else {
            Family familyPersisted = repository.save(mapper.toFamily(request));
            log.info("family persisted with Id {}", familyPersisted.getId());
            return mapper.fromFamily(familyPersisted);
        }
    }
}
