package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.*;
import com.example.demo.services.*;;

@RestController

@RequestMapping(path = "/api/projects", produces = "application/json")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT }, maxAge = 3600)

public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public List<Project> getProjecst() {
        return this.projectService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Optional<Project> opt = this.projectService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<Project>(opt.get(), HttpStatus.valueOf(302)); // Found
        else
            return new ResponseEntity<Project>(HttpStatus.valueOf(404)); // Not Found
    }

    @PostMapping("")
    public ResponseEntity<Project> addProject(@RequestBody Project entity) {
        if (this.projectService.save(entity).isPresent())
            return new ResponseEntity<Project>(entity, HttpStatus.valueOf(201)); // Created
        else
            return new ResponseEntity<Project>(HttpStatus.valueOf(400)); // Bad Request
    }

    @PutMapping("")
    public ResponseEntity<Project> updateProject(@RequestBody Project entity) {
        if (this.projectService.save(entity).isPresent())
            return new ResponseEntity<Project>(entity, HttpStatus.valueOf(201)); // Created
        else
            return new ResponseEntity<Project>(HttpStatus.valueOf(400)); // Bad Request
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id) {
        if (this.projectService.delete(id).isPresent())
            return new ResponseEntity<Project>(HttpStatus.valueOf(200)); // Ok
        else
            return new ResponseEntity<Project>(HttpStatus.valueOf(404)); // Not Found
    }
}
