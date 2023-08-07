package com.java.retrospective.controller;

import com.java.retrospective.entity.MessageEntity;
import com.java.retrospective.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/retrospective/{retro_id}/messages")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public String getMessages(@PathVariable Integer retro_id){
        messageService.getAllMessages().forEach((message)->{System.out.println(message.getMessage());});
        return "";
    }

    @PostMapping
    public String addMessages(@PathVariable Integer retro_id, @RequestBody MessageEntity message){
        return "Added: "+messageService.addMessage(message);
    }

    @DeleteMapping(value = "/{msg_id}?user={user_id}")
    public String deleteUserMessage(@PathVariable Integer retro_id, @PathVariable Integer msg_id, @RequestParam Integer user_id){
        return "Deleted: "+messageService.deleteMessage(msg_id);
    }

    @PutMapping(value = "/{msg_id}?user={user_id}")
    public String updateUserMessage(@PathVariable Integer retro_id, @PathVariable Integer msg_id, @RequestParam Integer user_id, @RequestBody String message){
        return "Updated: "+messageService.updateMessage(msg_id, message).toString();
    }

}
