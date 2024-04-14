package org.example.javaspringhomework5.service;

import lombok.AllArgsConstructor;
import org.example.javaspringhomework5.model.Task;
import org.example.javaspringhomework5.model.TaskStatus;
import org.example.javaspringhomework5.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }

    public void updateTaskStatus(Long id, TaskStatus newStatus) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setStatus(newStatus);
            taskRepository.save(task);
        });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
