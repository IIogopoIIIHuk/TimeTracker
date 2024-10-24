package com.example.testingTask.Repo;

import com.example.testingTask.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
