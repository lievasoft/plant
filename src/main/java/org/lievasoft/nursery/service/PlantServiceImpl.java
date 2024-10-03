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
import org.lievasoft.nursery.dto.PlantResponseDto;
import org.lievasoft.nursery.mapper.PlantMapper;
import org.lievasoft.nursery.repository.ImageRepository;
import org.lievasoft.nursery.repository.PlantRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private static final String FOLDER_PATH = "/home/josmaria/nursery/images/";

    private final PlantMapper mapper;
    private final PlantRepository plantJpaRepository;
    private final FamilyService familyService;
    private final ImageRepository imageRepository;

    @Override
    public PlantResponseDto create(final PlantCreateRequestDto request) {
        if (plantJpaRepository.existsByCommonName(request.commonName())) {
            throw new EntityExistsException(String.format("Plant with common name '%s' already exists", request.commonName()));
        }

        Family familyObtained = null;
        if (request.familyId() != null) {
            familyObtained = familyService.findById(request.familyId());
        }

        Plant plantMapped = mapper.toPlant(request, familyObtained);
        Plant plantPersisted = plantJpaRepository.save(plantMapped);
        log.info("Plant persisted with Id: {}", plantPersisted.getId());
        return mapper.fromPlant(plantPersisted);
    }

    @Override
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

            Image imagePersisted = imageRepository.save(Image.builder()
                    .name(file.getOriginalFilename())
                    .type(file.getContentType())
                    .path(directory.toAbsolutePath().toString())
                    .plant(plantObtained)
                    .build());

            Path filePath = directory.resolve(imagePersisted.getId());
            Files.write(filePath, file.getBytes());
            log.info("Image with Id: {}, uploaded successfully in the folder {}", imagePersisted.getId(), filePath.toAbsolutePath());

        } catch (IOException exception) {
            String message = "Could not upload image";
            log.warn(message);
            throw new RuntimeException(message);
        }
    }

    @Override
    public Resource downloadImageFromFileSystem(final Long plantId, final String imageId) {
        Resource resource = null;
        if (plantJpaRepository.existsById(plantId)) {
            Path directory = Paths.get(FOLDER_PATH + plantId);
            if (Files.exists(directory)) {
                Path filePath = Paths.get(FOLDER_PATH + plantId + "/").resolve(imageId).normalize();
                try {
                    resource = new UrlResource(filePath.toUri());
                    if (!resource.exists() || !resource.isReadable()) {
                        throw new FileSystemNotFoundException("Could not download image");
                    }
                } catch (MalformedURLException exception) {
                    throw new FileSystemNotFoundException(exception.getMessage());
                }
            }
        }
        return resource;
    }
}
