package com.java.retrospective.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="message")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    @NonNull private String message;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_user", referencedColumnName = "id")
    @NonNull private UserEntity user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_retrospective", referencedColumnName = "id")
    @NonNull private RetrospectiveEntity retrospective;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_swimlane", referencedColumnName = "id")
    @NonNull private SwimlaneEntity swimlane;
}
