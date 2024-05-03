package com.example.authorization.controllers;

import com.example.authorization.models.Application;
import com.example.authorization.models.MyUser;
import com.example.authorization.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //для сериализации ответов в json
@RequestMapping("api/v1/apps")
@AllArgsConstructor //будет сгенерирован конструктор с одним параметром для каждого поля вашего класса
public class AppController {
    private AppService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the unprotected page";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplications() {
        return service.allApplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application applicationByID(@PathVariable int id) {
        return service.applicationByID(id);
    }

    @PostMapping("/new-user")
    public String addUser(@RequestBody MyUser user) {
        service.addUser(user);
        return "User is saved";
    }
}
