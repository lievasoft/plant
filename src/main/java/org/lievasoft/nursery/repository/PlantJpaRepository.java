package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlantJpaRepository extends JpaRepository<Plant, Long> {

    boolean existsByCommonName(String commonName);

    /*@Query(name = "findAllPlantCards", nativeQuery = true)
    List<PlantCardDTO> findAllPlantCards(@Param("limit") int limit, @Param("offset") int offset);*/
}
