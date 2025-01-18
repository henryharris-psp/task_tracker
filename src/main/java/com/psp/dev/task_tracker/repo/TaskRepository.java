package com.psp.dev.task_tracker.repo;

import com.psp.dev.task_tracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
