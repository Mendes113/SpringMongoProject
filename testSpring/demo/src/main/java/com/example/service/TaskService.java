package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    // CRUD methods

   public Task createTask(Task task) {
    task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
    
    if (task.getTaskDescription() == null) {
        task.setTaskDescription("Default Description");
    }
    
    if (task.getTaskAssign() == null) {
        task.setTaskAssign("Unassigned");
    }
    
    return repository.save(task);
}


    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(String id) {
        Optional<Task> task = repository.findById(id);
        return task.orElse(null);
    }

    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssign(String assign) {
        return repository.findByAssign(assign);
    }

    public Task updateTask(String taskId, Task taskRequest) {
        Optional<Task> existingTask = repository.findById(taskId);
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setTaskDescription(taskRequest.getTaskDescription());
            updatedTask.setSeverity(taskRequest.getSeverity());
            updatedTask.setTaskAssign(taskRequest.getTaskAssign());
            updatedTask.setStoryPoint(taskRequest.getStoryPoint());
            return repository.save(updatedTask);
        } else {
            return null; // Handle case when task does not exist
        }
    }

    public String deleteTask(String taskId) {
        repository.deleteById(taskId);
        return "Task deleted successfully: " + taskId;
    }
}
