package com.example.testingTask;

import lombok.Data;

@Data
public class StartRecordRequest {
    private Long userId;
    private Long projectId;
    private String description;


    public StartRecordRequest() {
    }


    public StartRecordRequest(Long userId, Long projectId, String description) {
        this.userId = userId;
        this.projectId = projectId;
        this.description = description;
    }

}
