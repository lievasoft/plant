package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Plant;
import org.lievasoft.nursery.dto.PlantCardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantJpaRepository extends JpaRepository<Plant, Long> {

    boolean existsByCommonName(String commonName);

    @Query(name = "findAllPlantCardByPagination", nativeQuery = true)
    List<PlantCardDto> findAllPlantCardByPagination(@Param("limit") int limit, @Param("offset") int offset);
}
