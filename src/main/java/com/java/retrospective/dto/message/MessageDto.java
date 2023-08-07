package com.java.retrospective.dto.message;

import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.entity.UserEntity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageDto {
    private String message;
    private UserEntity user;
    private RetrospectiveEntity retrospective;
    private SwimlaneEntity swimlane;

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
