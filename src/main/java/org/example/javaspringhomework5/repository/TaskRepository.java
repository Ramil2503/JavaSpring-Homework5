package org.example.javaspringhomework5.repository;

import org.example.javaspringhomework5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
