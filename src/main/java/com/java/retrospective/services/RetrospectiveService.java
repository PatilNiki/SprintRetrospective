package com.java.retrospective.services;

import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;

import java.util.List;

public interface RetrospectiveService {
    List<RetrospectiveOutDto> getAllRetrospectives();
    RetrospectiveOutDto addRetrospective(RetrospectiveInDto retrospectiveEntity);
    RetrospectiveOutDto getRetrospective(Integer id);
    String deleteRetrospective(Integer id);
    RetrospectiveOutDto updateRetrospective(Integer id, RetrospectiveInDto retrospective);

}
