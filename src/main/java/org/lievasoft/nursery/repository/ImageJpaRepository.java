package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ImageJpaRepository extends JpaRepository<Image, String> {

    @Query(value = """
        SELECT image.id
        FROM images image
        WHERE image.plant_id = :plantId
        LIMIT 1
    """, nativeQuery = true)
    Optional<String>  findIdByPlantId(@Param("plantId") Long plantId);
}
