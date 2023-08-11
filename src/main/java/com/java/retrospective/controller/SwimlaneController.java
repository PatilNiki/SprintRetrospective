package com.java.retrospective.controller;

import java.util.List;

import com.java.retrospective.dto.swimlane.SwimlaneInDto;
import com.java.retrospective.dto.swimlane.SwimlaneOutDto;
import com.java.retrospective.services.SwimlaneService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/retrospectives/{retro_id}/swimlanes")
@AllArgsConstructor
public class SwimlaneController {
    private final SwimlaneService swimlaneService;

    @GetMapping
    public List<SwimlaneOutDto> getSwimlanes(@PathVariable Integer retro_id){
        return swimlaneService.getAllSwimlanes(retro_id);
    }

    @PostMapping
    public String addSwimlanes(@PathVariable Integer retro_id, @RequestBody SwimlaneInDto swimlane_title){
//        System.out.println("Swimlane title: "+swimlane_title);
        return "Added: "+swimlaneService.addSwimlane(retro_id, swimlane_title);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteSwimlane(@PathVariable Integer retro_id, @PathVariable Integer id){
        return "Deleted: "+swimlaneService.deleteSwimlane(retro_id, id);
    }



}
