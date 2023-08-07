package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="retrospective")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
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
    @NonNull private List<SwimlaneEntity> swimlanes= new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SwimlaneEntity> getSwimlanes() {
        return swimlanes;
    }

    public void setSwimlanes(List<SwimlaneEntity> swimlanes) {
        this.swimlanes = swimlanes;
    }
}
