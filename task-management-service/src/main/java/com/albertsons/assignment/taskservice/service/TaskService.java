package com.albertsons.assignment.taskservice.service;

import com.albertsons.assignment.taskservice.dto.TaskRequest;
import com.albertsons.assignment.taskservice.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(Long id, TaskRequest request);

    void deleteTask(Long id);
}