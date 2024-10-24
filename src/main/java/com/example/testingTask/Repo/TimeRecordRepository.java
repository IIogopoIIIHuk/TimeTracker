package com.example.testingTask.Repo;

import com.example.testingTask.Project;
import com.example.testingTask.TimeRecord;
import com.example.testingTask.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
    List<TimeRecord> findAllByUser(User user);
    List<TimeRecord> findAllByProject(Project project);
}
