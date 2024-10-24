package com.example.testingTask.Controller;


import com.example.testingTask.Service.TimeRecordService;
import com.example.testingTask.StartRecordRequest;
import com.example.testingTask.TimeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class TimeRecordController {

    @Autowired
    private TimeRecordService timeRecordService;

    @PostMapping("/start")
    public ResponseEntity<?> startRecord(@RequestBody StartRecordRequest request) {
        timeRecordService.creatTimeRecord(request.getUserId(), request.getProjectId(), LocalDateTime.now(), request.getDescription());
        return ResponseEntity.ok("Time tracking started");
    }

    @PostMapping("/stop/{recordId}")
    public ResponseEntity<?> stopRecord(@PathVariable Long recordId) {
        timeRecordService.stopTimeRecord(recordId, LocalDateTime.now());
        return ResponseEntity.ok("Time tracking stopped");
    }

    @GetMapping("/user/{userId}")
    public List<TimeRecord> getUserRecords(@PathVariable Long userId) {
        return timeRecordService.getRecordsByUser(userId);
    }

}
