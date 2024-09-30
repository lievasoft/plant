package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    boolean existsByCommonName(String commonName);
}
