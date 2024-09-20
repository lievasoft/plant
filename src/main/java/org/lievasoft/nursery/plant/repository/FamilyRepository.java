package org.lievasoft.nursery.plant.repository;

import org.lievasoft.nursery.plant.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, String> {

    boolean existsByName(String name);
}
