package com.example.testingTask;

import lombok.Data;

@Data
public class ProjectRequest {

    private String name;
    private String description;


    public ProjectRequest() {
    }


    public ProjectRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }
}