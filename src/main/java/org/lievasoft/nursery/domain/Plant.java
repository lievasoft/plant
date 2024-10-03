package org.lievasoft.nursery.domain;

import jakarta.persistence.*;
import lombok.*;
import org.lievasoft.nursery.dto.CardResponseDto;
import org.lievasoft.nursery.enums.Classification;
import org.lievasoft.nursery.enums.Status;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@NamedNativeQuery(
        name = "findAllPlantCardByPagination",
        query = """
            SELECT p.id, common_name, scientific_name, status
            FROM plants p
            ORDER BY p.common_name
            LIMIT :limit OFFSET :offset
        """,
        resultSetMapping = "PlantCardMapping"
)
@SqlResultSetMapping(
        name = "PlantCardMapping",
        classes = @ConstructorResult(
                targetClass = CardResponseDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "common_name", type = String.class),
                        @ColumnResult(name = "scientific_name", type = String.class),
                        @ColumnResult(name = "status", type = Status.class),
                        @ColumnResult(name = "imageId", type = String.class),
                }
        )
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "plant_sequence")
    @SequenceGenerator(name = "plant_sequence", sequenceName = "plant_sequence", allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String commonName;

    @Column(length = 100)
    private String scientificName;

    @Column(length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ElementCollection(targetClass = Classification.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private Set<Classification> classifications;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @Column(precision = 5, scale = 2)
    private BigDecimal price;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedAt;

    @OneToOne(cascade = { PERSIST, REMOVE })
    @JoinColumn(name = "information_id", nullable = false)
    private Information information;

    @OneToMany(mappedBy = "plant", fetch = FetchType.LAZY, cascade = REMOVE)
    private Set<Image> images;
}
