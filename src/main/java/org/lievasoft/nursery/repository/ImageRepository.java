package org.lievasoft.nursery.repository;

import org.lievasoft.nursery.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
