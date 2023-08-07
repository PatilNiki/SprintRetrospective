package com.java.retrospective.entity;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name="message")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RetrospectiveEntity getRetrospective() {
        return retrospective;
    }

    public void setRetrospective(RetrospectiveEntity retrospective) {
        this.retrospective = retrospective;
    }

    public SwimlaneEntity getSwimlane() {
        return swimlane;
    }

    public void setSwimlane(SwimlaneEntity swimlane) {
        this.swimlane = swimlane;
    }
}
