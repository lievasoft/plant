package org.lievasoft.nursery.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lievasoft.nursery.domain.Family;
import org.lievasoft.nursery.domain.Image;
import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.lievasoft.nursery.mapper.PlantMapper;
import org.lievasoft.nursery.repository.FamilyRepository;
import org.lievasoft.nursery.repository.PlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private static final String FOLDER_PATH = "/home/josmaria/nursery/images/";

    private final PlantMapper mapper;
    private final PlantRepository plantJpaRepository;
    private final FamilyRepository familyRepository;

    @Override
    public PlantCreateResponseDto create(final PlantCreateRequestDto request) {
        if (plantJpaRepository.existsByCommonName(request.commonName())) {
            throw new EntityExistsException(String.format("Plant with common name '%s' already exists", request.commonName()));
        }

        Family familyObtained = null;
        if (request.familyId() != null) {
            familyObtained = familyRepository.findById(request.familyId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            String.format("Family with Id: %s does not exists when we are creating a plant", request.familyId())
                    ));
        }

        Plant plantMapped = mapper.toPlant(request, familyObtained);
        Plant plantPersisted = plantJpaRepository.save(plantMapped);
        log.info("Plant persisted with Id: {}", plantPersisted.getId());
        return mapper.fromPlant(plantPersisted);
    }

    @Transactional(rollbackOn = Exception.class)
    public void uploadImageToFileSystem(final Long plantId, final MultipartFile file) {
        Plant plantObtained = plantJpaRepository.findById(plantId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Plant with ID %s not found.", plantId)
                ));

        try {
            Path directory = Paths.get(FOLDER_PATH + plantId);
            if (!Files.exists(directory)) {
                Files.createDirectory(directory);
            }

            String imageId = UUID.randomUUID().toString();
            plantObtained.addImage(Image.builder()
                    .id(imageId)
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .path(directory.toAbsolutePath().toString())
                    .plant(plantObtained)
                    .build()
            );

            Path filePath = directory.resolve(imageId);
            Files.write(filePath, file.getBytes());
            log.info("Image with Id: {}, uploaded successfully in the folder {}", imageId, filePath.toAbsolutePath());

        } catch (IOException exception) {
            String message = "Could not upload image";
            log.warn(message);
            throw new RuntimeException(message);
        }
    }
}
