package com.java.retrospective.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.mappers.RetrospectiveMapper;
import com.java.retrospective.services.RetrospectiveService;

import com.java.retrospective.validator.RetrospectiveValidator;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrospectiveServiceImpl implements RetrospectiveService {
    private final RetrospectiveDao retrospectiveDao;
    private final RetrospectiveMapper retrospectiveMapper;
    private final RetrospectiveValidator retrospectiveValidator;

    @Override
    public List<RetrospectiveOutDto> getAllRetrospectives() {
        return retrospectiveDao.findAll().stream().map(retrospectiveMapper::mapEntityToOutDto).collect(Collectors.toList());
    }

    @Override
    public RetrospectiveOutDto addRetrospective(RetrospectiveInDto retrospectiveInDto) {
        if(retrospectiveValidator.validateForCreate(retrospectiveInDto)) {
            return retrospectiveMapper.mapEntityToOutDto(retrospectiveDao.save(retrospectiveMapper.mapInDtoToEntity(retrospectiveInDto)));
        }
        return null;
    }

    @Override
    public RetrospectiveOutDto getRetrospective(Integer id) {
        return retrospectiveMapper.mapEntityToOutDto(retrospectiveDao.findById(id).orElse(null));
    }

    @Override
    public String deleteRetrospective(Integer id) {
        retrospectiveDao.deleteById(id);
        return "Retrospective deleted!";
    }

    @Override
    public RetrospectiveOutDto updateRetrospective(Integer id, RetrospectiveInDto retrospective) {
        if(retrospectiveValidator.validateForCreate(retrospective)) {
            RetrospectiveEntity retrospectiveEntity = retrospectiveDao.findById(id).orElse(null);
            if(retrospectiveEntity!=null) {
                retrospectiveEntity.setTitle(retrospective.getTitle());
                retrospectiveEntity.setDescription(retrospective.getDescription());
                return retrospectiveMapper.mapEntityToOutDto(retrospectiveDao.save(retrospectiveEntity));
            }
        }
        return null;
    }

    @Override
    public RetrospectiveEntity getRetrospectiveEntity(Integer id) {
        return retrospectiveDao.findById(id).orElse(null);
    }
}
