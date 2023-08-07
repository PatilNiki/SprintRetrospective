package com.java.retrospective.controller;

import java.util.List;

import com.java.retrospective.dto.retrospeective.RetrospectiveInDto;
import com.java.retrospective.dto.retrospeective.RetrospectiveOutDto;
import com.java.retrospective.services.RetrospectiveService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/retrospectives")
@AllArgsConstructor
public class RetrospectiveController {
    private final RetrospectiveService retrospectiveService;

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
