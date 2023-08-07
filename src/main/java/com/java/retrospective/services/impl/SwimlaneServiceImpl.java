package com.java.retrospective.services.impl;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dao.SwimlaneDao;
import com.java.retrospective.dto.swimlane.SwimlaneDto;
import com.java.retrospective.dto.user.UserDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.entity.UserEntity;
import com.java.retrospective.services.SwimlaneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SwimlaneServiceImpl implements SwimlaneService {

    @Autowired
    private SwimlaneDao swimlaneDao;
    @Autowired
    private RetrospectiveDao retrospectiveDao;

    @Override
    public List<SwimlaneDto> getAllSwimlanes(Integer retro_id) {
//        List<SwimlaneEntity> swimlaneEntities = swimlaneDao.findAll().stream().filter(swimlaneEntity -> swimlaneEntity.getRetrospective().getId().equals(retro_id)).collect(Collectors.toList());
//        return swimlaneEntities.stream().map(this::convertDataIntoDto).collect(Collectors.toList());
        List<SwimlaneEntity> swimlaneEntities = swimlaneDao.findByRetrospectiveId(retro_id);
        return  swimlaneEntities.stream().map(this::convertDataIntoDto).collect(Collectors.toList());
    }

    @Override
    public SwimlaneDto addSwimlane(Integer retro_id, String swimlaneTitle) {
        Optional<RetrospectiveEntity> optionalRetrospectiveEntity= retrospectiveDao.findById(retro_id);
        if(optionalRetrospectiveEntity.isPresent()){
            RetrospectiveEntity retrospectiveEntity = optionalRetrospectiveEntity.get();
            SwimlaneEntity swimlaneEntity = new SwimlaneEntity();
            swimlaneEntity.setRetrospective(retrospectiveEntity);
            swimlaneEntity.setTitle(swimlaneTitle);
            return convertDataIntoDto(swimlaneDao.save(swimlaneEntity));
        }else{
            return null;
        }

    }

    @Override
    public String deleteSwimlane(Integer retro_id, Integer id) {
        swimlaneDao.deleteById(id);
        return "Swimlane deleted!";
    }
    private SwimlaneDto convertDataIntoDto(SwimlaneEntity swimlane){
        SwimlaneDto swimlaneDto= new SwimlaneDto();
        swimlaneDto.setTitle(swimlane.getTitle());
        swimlaneDto.setRetrospective(swimlane.getRetrospective());
        return swimlaneDto;
    }
}
