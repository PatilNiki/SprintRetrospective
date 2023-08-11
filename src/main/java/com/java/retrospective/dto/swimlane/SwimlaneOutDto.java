package com.java.retrospective.dto.swimlane;

import com.java.retrospective.dto.retrospeective.SimpleRetrospectiveOutDto;
import lombok.Data;

@Data
public class SwimlaneOutDto {
    private String title;
    private SimpleRetrospectiveOutDto retrospective= new SimpleRetrospectiveOutDto();
}
