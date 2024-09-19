package org.lievasoft.nursery.plant;

import org.lievasoft.nursery.plant.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
