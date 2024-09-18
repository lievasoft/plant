package org.lievasoft.nursery.plant;

import org.springframework.stereotype.Service;

@Service
public class PlantServiceImpl implements PlantService {

    @Override
    public String create(PlantCreateRequest request) {
        return "successfully";
    }
}
