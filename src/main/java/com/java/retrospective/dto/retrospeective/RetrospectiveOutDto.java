package com.java.retrospective.dto.retrospeective;

import com.java.retrospective.entity.SwimlaneEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RetrospectiveOutDto {
    private String title;
    private String description;
    private List<SwimlaneEntity> swimlanes;

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
