package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

    List < Task > findBySeverity(int severity);

    @Query("{taskAssign: ?0}")
    List < Task > findByAssign(String assign);
}