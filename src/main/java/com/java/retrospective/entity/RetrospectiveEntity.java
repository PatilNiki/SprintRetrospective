package com.java.retrospective.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="retrospective")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RetrospectiveEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    @NonNull private String title;
    @Column
    private String description;
    @OneToMany(mappedBy = "retrospective")
    @JsonManagedReference
    @NonNull private List<SwimlaneEntity> swimlanes= new ArrayList<>();
}
