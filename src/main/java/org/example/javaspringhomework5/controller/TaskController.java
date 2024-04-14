package org.example.javaspringhomework5.controller;


import lombok.AllArgsConstructor;
import org.example.javaspringhomework5.model.Task;
import org.example.javaspringhomework5.model.TaskStatus;
import org.example.javaspringhomework5.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    // to use this method send GET Request to localhost:8080/tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // to use this method send POST Request to localhost:8080/tasks
    // in the body provide description and status of the task
    // for example:
    // {
    //    "description": "hello",
    //    "status": "IN_PROGRESS"
    //}
    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    // to use this method send GET Request to localhost:8080/status/{status}
    // REPLACE "{status}" with one of the valid status values
    // the valid status values are: NOT_STARTED, IN_PROGRESS, COMPLETED
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable("status") String status) {
        return taskService.getTasksByStatus(TaskStatus.valueOf(status));
    }

    // to use this method send PUT Request to localhost:8080/update/{id}
    // REPLACE "{id}" with one of the valid id values
    // in the body provide new status of the task
    // for example: "COMPLETED"
    // the valid status values are: NOT_STARTED, IN_PROGRESS, COMPLETED
    @PutMapping("/update/{id}")
    public void updateTaskStatus(@PathVariable("id") Long id, @RequestBody TaskStatus newStatus) {
        taskService.updateTaskStatus(id, newStatus);
    }

    // to use this method send DELETE Request to localhost:8080/delete/{id}
    // REPLACE "{id}" with one of the valid id values
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }
}
