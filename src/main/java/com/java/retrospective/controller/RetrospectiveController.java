package com.java.retrospective.controller;

import com.java.retrospective.dao.RetrospectiveDao;
import com.java.retrospective.entity.RetrospectiveEntity;
import com.java.retrospective.services.RetrospectiveService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RetrospectiveController {
    RetrospectiveService retrospectiveService;

    @GetMapping(value = "/retrospectives")
    public String getRetrospectives(){
        retrospectiveService.getAllRetrospectives().forEach(retrospective -> System.out.println("Title: "+retrospective.getTitle()+" Description: "+retrospective.getDescription()));
        return "";
    }

    @PostMapping(value = "/retrospectives")
    public String addRetrospective(@RequestBody RetrospectiveEntity retrospective){
        return "Added: "+ retrospectiveService.addRetrospective(retrospective);
    }

    @GetMapping(value = "/retrospectives/{id}")
    public String getRetrospective(@PathVariable Integer id){
        return "Retrospective: "+ retrospectiveService.getRetrospective(id);
    }

    @DeleteMapping(value = "/retrospectives/{id}")
    public String deleteRetrospective(@PathVariable Integer id){
        return "Deleted: "+ retrospectiveService.deleteRetrospective(id);
    }

    @PutMapping(value = "/retrospectives/{id}")
    public String updateRetrospective(@PathVariable Integer id, @RequestBody RetrospectiveEntity retrospective){
        return "Updated: "+retrospectiveService.updateRetrospective(id, retrospective);
    }
}
