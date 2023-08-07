package com.java.retrospective.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
