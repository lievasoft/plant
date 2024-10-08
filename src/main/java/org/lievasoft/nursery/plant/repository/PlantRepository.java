package org.lievasoft.nursery.plant.repository;

import org.lievasoft.nursery.plant.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
