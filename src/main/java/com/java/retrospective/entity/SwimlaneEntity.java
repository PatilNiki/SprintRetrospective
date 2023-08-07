package com.java.retrospective.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="swimlane")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SwimlaneEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    @NonNull private String title;

    @ManyToOne
    @JoinColumn(name = "ref_retrospective", referencedColumnName = "id")
    private RetrospectiveEntity retrospective;
}
