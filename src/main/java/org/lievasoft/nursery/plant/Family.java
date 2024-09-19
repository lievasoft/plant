package org.lievasoft.nursery.plant;

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

    @Column(length = 100, nullable = false)
    private String name;

    @OneToMany(mappedBy = "families")
    private List<Plant> plants;
}
