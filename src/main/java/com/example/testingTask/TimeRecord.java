package com.example.testingTask;

import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "time_records")
@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TimeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    @Column(nullable = false)
    private LocalDateTime startEndPoint;

    private LocalDateTime finalEndPoint;

    private Duration duration;

    private String description;

}
