package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="swimlane")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    public RetrospectiveEntity getRetrospective() {
        return retrospective;
    }

    public void setRetrospective(RetrospectiveEntity retrospective) {
        this.retrospective = retrospective;
    }
}
