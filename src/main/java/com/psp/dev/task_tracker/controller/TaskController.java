package com.psp.dev.task_tracker.controller;

import com.psp.dev.task_tracker.model.Task;
import com.psp.dev.task_tracker.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid Task task) {
        if (task == null) {
            return ResponseEntity.badRequest().build(); // to check if task is null
        }
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

//    @PostMapping("/singleTask")
//    public ResponseEntity<Task> createTask(@RequestBody @Valid Task) {
//        if (task == null) {
//            return ResponseEntity.badRequest().build(); // to check if task is null
//        }
//        Task createdTask = taskService.createTask(task);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
//    }
//
//    @PostMapping("/multipleTasks")
//    public ResponseEntity<List<Task>> createTasks(@RequestBody @Valid List<Task> tasks) {
//        if (tasks == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        List<Task> createdTasks = taskService.createTasks(tasks);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdTasks);
//    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
