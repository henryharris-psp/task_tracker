package com.psp.dev.task_tracker.service;

import com.psp.dev.task_tracker.model.Task;
import com.psp.dev.task_tracker.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; //enable communication with database

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> createTasks(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(int id,Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setPriority(updatedTask.getPriority());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

}
