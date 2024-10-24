package com.example.testingTask.Service;

import com.example.testingTask.Project;
import com.example.testingTask.Repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(String title, String description){
        Project project = new Project();
        project.setTitle(title);
        project.setDescription(description);
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
