package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="swimlane")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SwimlaneEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    @NonNull private Integer id;
    @Column
    @NonNull private String title;

    @ManyToOne
    @JoinColumn(name = "ref_retrospective", referencedColumnName = "id")
    private RetrospectiveEntity retrospective;
}
