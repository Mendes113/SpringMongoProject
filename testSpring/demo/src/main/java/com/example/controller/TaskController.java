package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Task;
import com.example.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return service.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity) {
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assign/{assign}")
    public List<Task> getTaskByAssign(@PathVariable String assign) {
        return service.getTaskByAssign(assign);
    }

    @PostMapping("/{taskId}")
    public Task modifyTask(@PathVariable String taskId, @RequestBody Task taskRequest) {
        return service.updateTask(taskId, taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTaskString(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }
}
