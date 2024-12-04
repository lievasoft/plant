package org.lievasoft.nursery.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Information {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "information_sequence")
    @SequenceGenerator(name = "information_sequence", sequenceName = "information_sequence", allocationSize = 1)
    private Long id;

    private String description;
    private String origin;
    private String size;
    private String flowering;
    private String location;
    private String soil;
    private String fertilization;
    private String pruning;
    private String propagation;
}
