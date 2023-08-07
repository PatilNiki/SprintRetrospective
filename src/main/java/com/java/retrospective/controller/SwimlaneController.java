package com.java.retrospective.controller;

import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.services.SwimlaneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SwimlaneController {
    SwimlaneService swimlaneService;

    @GetMapping(value = "retrospective/{retro_id}/swimlanes")
    public void getSwimlanes(@PathVariable Integer retro_id){
        List<SwimlaneEntity> swimlanes = swimlaneService.getAllSwimlanes().stream().filter(swimlane->swimlane.getRetrospective().getId()==retro_id).collect(Collectors.toList());
        swimlanes.forEach(swimlane-> System.out.println("Title: "+swimlane.getTitle()));
    }

    @PostMapping(value = "retrospective/{retro_id}/swimlanes")
    public String addSwimlanes(@PathVariable Integer retro_id, @RequestBody SwimlaneEntity swimlane){
        return "Added: "+swimlaneService.addSwimlane(swimlane);
    }

    @DeleteMapping(value = "retrospective/{retro_id}/swimlanes/{id}")
    public String deleteSwimlane(@PathVariable Integer retro_id, @PathVariable Integer id){
        return "Deleted: "+swimlaneService.deleteSwimlane(id);
    }



}
