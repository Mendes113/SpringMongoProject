package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Task {
    @Id
    private String taskId;
    private String taskDescription;
    private int severity;
    private String taskAssign;
    private int storyPoint;
}
