package org.lievasoft.nursery.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(length = 100, updatable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    private String name;
    private String type;
    private String path;
}
