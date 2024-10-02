package org.lievasoft.nursery.service;

import org.lievasoft.nursery.dto.PlantCreateRequestDto;
import org.lievasoft.nursery.dto.PlantCreateResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface PlantService {

    PlantCreateResponseDto create(PlantCreateRequestDto request);

    void uploadImageToFileSystem(Long plantId, MultipartFile file);
}
