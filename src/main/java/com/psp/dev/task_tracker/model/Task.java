package com.psp.dev.task_tracker.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.psp.dev.task_tracker.common.Status;
import com.psp.dev.task_tracker.common.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title is required...")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "Description is required...")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Date is required...")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status = Status.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority = Priority.LOW;

}
