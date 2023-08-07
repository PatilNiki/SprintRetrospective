package com.java.retrospective.dto.swimlane;

import com.java.retrospective.entity.RetrospectiveEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SwimlaneDto {
    private String title;
    private RetrospectiveEntity retrospective;

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
