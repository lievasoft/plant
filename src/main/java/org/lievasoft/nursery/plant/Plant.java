package org.lievasoft.nursery.plant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @UuidGenerator
    private String id;

    private String commonName;
}
