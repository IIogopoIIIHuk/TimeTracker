package com.example.testingTask.Service;

import com.example.testingTask.Project;
import com.example.testingTask.Repo.ProjectRepository;
import com.example.testingTask.Repo.TimeRecordRepository;
import com.example.testingTask.Repo.UserRepository;
import com.example.testingTask.TimeRecord;
import com.example.testingTask.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeRecordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimeRecordRepository timeRecordRepository;

    @Autowired
    private ProjectRepository projectRepository;


    public TimeRecord creatTimeRecord(Long userId, Long projectId, LocalDateTime startEndPoint, String description){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));

        TimeRecord timeRecord = new TimeRecord();
        timeRecord.setUser(user);
        timeRecord.setProject(project);
        timeRecord.setStartEndPoint(startEndPoint);
        timeRecord.setDescription(description);
        return timeRecordRepository.save(timeRecord);
    }

    public TimeRecord stopTimeRecord(Long recordId, LocalDateTime finalEndPoint){
        TimeRecord timeRecord = timeRecordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found"));

        timeRecord.setFinalEndPoint(finalEndPoint);
        timeRecord.setDuration(Duration.between(timeRecord.getStartEndPoint(), finalEndPoint));
        return timeRecordRepository.save(timeRecord);
    }

    public List<TimeRecord> getRecordsByUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return timeRecordRepository.findAllByUser(user);
    }

}
