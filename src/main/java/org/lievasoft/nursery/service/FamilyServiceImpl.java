package org.lievasoft.nursery.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.dto.FamilyCreateRequestDto;
import org.lievasoft.nursery.dto.FamilyResponseDto;
import org.lievasoft.nursery.mapper.FamilyMapper;
import org.lievasoft.nursery.repository.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FamilyServiceImpl implements FamilyService {

    private final FamilyMapper mapper;
    private final FamilyRepository repository;

    @Override
    public FamilyResponseDto create(final FamilyCreateRequestDto request) {
        if (repository.existsByName(request.name())) {
            throw new EntityExistsException(String.format("family with name '%s' already exists", request.name()));

        } else {
            Family familyPersisted = repository.save(mapper.toFamily(request));
            log.info("family persisted with Id {}", familyPersisted.getId());
            return mapper.fromFamily(familyPersisted);
        }
    }

    @Override
    public List<FamilyResponseDto> findAll() {
        List<Family> familiesObtained = repository.findAll();
        log.info("families obtained");
        return familiesObtained.stream()
                .map(mapper::fromFamily)
                .toList();
    }

    @Override
    public Family findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Family with Id: %s does not exists when we are creating a plant", id)
                ));
    }
}
