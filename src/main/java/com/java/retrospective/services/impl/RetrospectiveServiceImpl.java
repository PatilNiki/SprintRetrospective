package com.java.retrospective.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.services.RetrospectiveService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RetrospectiveServiceImpl implements RetrospectiveService {
    private final RetrospectiveDao retrospectiveDao;

    @Override
    public List<RetrospectiveOutDto> getAllRetrospectives() {
        return retrospectiveDao.findAll().stream().map(this::convertDataIntoDto).collect(Collectors.toList());
    }

    @Override
    public RetrospectiveOutDto addRetrospective(RetrospectiveInDto retrospectiveInDto) {
        return convertDataIntoDto(retrospectiveDao.save(convertDataIntoEntity(retrospectiveInDto)));
    }

    @Override
    public RetrospectiveOutDto getRetrospective(Integer id) {
        Optional<RetrospectiveEntity> optionalRetrospectiveEntity = retrospectiveDao.findById(id);
        if(optionalRetrospectiveEntity.isPresent()){
            return convertDataIntoDto(optionalRetrospectiveEntity.get());
        }
        return null;
    }

    @Override
    public String deleteRetrospective(Integer id) {
        retrospectiveDao.deleteById(id);
        return "Retrospective deleted!";
    }

    @Override
    public RetrospectiveOutDto updateRetrospective(Integer id, RetrospectiveInDto retrospective) {
        Optional<RetrospectiveEntity> optionalRetrospectiveEntity = retrospectiveDao.findById(id);
        if(optionalRetrospectiveEntity.isPresent()){
            RetrospectiveEntity retrospectiveEntity = optionalRetrospectiveEntity.get();
            retrospectiveEntity.setTitle(retrospective.getTitle());
            retrospectiveEntity.setDescription(retrospective.getDescription());
            return convertDataIntoDto(retrospectiveDao.save(retrospectiveEntity));
        }
        return null;
    }

    private RetrospectiveOutDto convertDataIntoDto(RetrospectiveEntity retrospective){
        RetrospectiveOutDto retrospectiveDto= new RetrospectiveOutDto();
        retrospectiveDto.setTitle(retrospective.getTitle());
        retrospectiveDto.setDescription(retrospective.getDescription());
        retrospectiveDto.setSwimlanes(retrospective.getSwimlanes());
        return retrospectiveDto;
    }

    private RetrospectiveEntity convertDataIntoEntity(RetrospectiveInDto retrospectiveInDto){
        RetrospectiveEntity retrospectiveEntity= new RetrospectiveEntity();
        retrospectiveEntity.setTitle(retrospectiveInDto.getTitle());
        retrospectiveEntity.setDescription(retrospectiveInDto.getDescription());
        return retrospectiveEntity;
    }
}
