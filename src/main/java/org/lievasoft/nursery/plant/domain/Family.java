package org.lievasoft.nursery.plant.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "families")
public class Family {

    @Id
    @UuidGenerator
    @Column(length = 100)
    private String id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "family")
    private List<Plant> plants;
}
