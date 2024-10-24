package com.example.testingTask.Controller;

import com.example.testingTask.Project;
import com.example.testingTask.ProjectRequest;
import com.example.testingTask.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createProject(@RequestParam ProjectRequest request){
        projectService.createProject(request.getName(), request.getDescription());
        return ResponseEntity.ok("Project created succesfully");
    }

    @GetMapping
    public List<Project> getAllProject(){
        return projectService.getAllProjects();
    }
}
