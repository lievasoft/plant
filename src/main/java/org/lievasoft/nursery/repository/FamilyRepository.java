package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, String> {

    boolean existsByName(String name);
}
