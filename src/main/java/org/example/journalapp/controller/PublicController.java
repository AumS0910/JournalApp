package org.example.journalapp.controller;

import org.example.journalapp.entity.User;
import org.example.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String HealthCheck() {
        return "OK";
    }



    @PostMapping("create-user")
    public void create(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
