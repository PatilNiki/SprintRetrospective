package com.java.retrospective.controller;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.services.RetrospectiveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/retrospectives")
@AllArgsConstructor
public class RetrospectiveController {
    @Autowired
    RetrospectiveService retrospectiveService;

    @GetMapping
    public List<RetrospectiveOutDto> getRetrospectives(){
        return retrospectiveService.getAllRetrospectives();
    }

    @PostMapping
    public RetrospectiveOutDto addRetrospective(@RequestBody RetrospectiveInDto retrospective){
        return retrospectiveService.addRetrospective(retrospective);
    }

    @GetMapping(value = "/{id}")
    public RetrospectiveOutDto getRetrospective(@PathVariable Integer id){
        return retrospectiveService.getRetrospective(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteRetrospective(@PathVariable Integer id){
        return "Deleted: "+ retrospectiveService.deleteRetrospective(id);
    }

    @PutMapping(value = "/{id}")
    public RetrospectiveOutDto updateRetrospective(@PathVariable Integer id, @RequestBody RetrospectiveInDto retrospective){
        return retrospectiveService.updateRetrospective(id, retrospective);
    }
}
