package com.pramodvaddiraju.TaskVerse.controller;

import com.pramodvaddiraju.TaskVerse.dto.TaskRequestDto;
import com.pramodvaddiraju.TaskVerse.dto.TaskResponseDto;
import com.pramodvaddiraju.TaskVerse.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto){
        return ResponseEntity.status(201).body(taskService.createTask(taskRequestDto));
    }

    @GetMapping
    ResponseEntity<Page<TaskResponseDto>> getAllTasks(Pageable pageable){
        return ResponseEntity.ok().body(taskService.getAllTasks(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}
