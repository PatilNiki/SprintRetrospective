package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    @NonNull private Integer id;
    @Column
    @NonNull private String username;
    @Column
    @NonNull private String password;
}
