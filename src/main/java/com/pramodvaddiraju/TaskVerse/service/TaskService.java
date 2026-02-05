package com.pramodvaddiraju.TaskVerse.service;

import com.pramodvaddiraju.TaskVerse.dto.TaskRequestDto;
import com.pramodvaddiraju.TaskVerse.dto.TaskResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    Page<TaskResponseDto> getAllTasks(Pageable pageable);
    TaskResponseDto getTaskById(Long id);
    void deleteTaskById(Long id);


}
