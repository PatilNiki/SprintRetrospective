package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="retrospective")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RetrospectiveEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    @NonNull private Integer id;
    @Column
    @NonNull private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "retrospective")
    @NonNull private List<SwimlaneEntity> swimlanes;

}
