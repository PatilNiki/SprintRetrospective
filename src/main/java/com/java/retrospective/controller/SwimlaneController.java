package com.java.retrospective.controller;

import com.java.retrospective.dto.swimlane.SwimlaneDto;
import com.java.retrospective.entity.SwimlaneEntity;
import com.java.retrospective.services.SwimlaneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/retrospective/{retro_id}/swimlanes")
@AllArgsConstructor
public class SwimlaneController {
    @Autowired
    SwimlaneService swimlaneService;

    @GetMapping
    public List<SwimlaneDto> getSwimlanes(@PathVariable Integer retro_id){
        return swimlaneService.getAllSwimlanes(retro_id);
    }

    @PostMapping
    public String addSwimlanes(@PathVariable Integer retro_id, @RequestBody String swimlane_title){
        return "Added: "+swimlaneService.addSwimlane(retro_id, swimlane_title);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteSwimlane(@PathVariable Integer retro_id, @PathVariable Integer id){
        return "Deleted: "+swimlaneService.deleteSwimlane(retro_id, id);
    }



}
