package org.lievasoft.nursery.plant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @UuidGenerator
    private String id;

    private String commonName;
}
