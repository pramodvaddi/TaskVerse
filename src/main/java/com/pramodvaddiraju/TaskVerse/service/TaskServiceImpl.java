package com.pramodvaddiraju.TaskVerse.service;

import com.pramodvaddiraju.TaskVerse.dto.TaskRequestDto;
import com.pramodvaddiraju.TaskVerse.dto.TaskResponseDto;
import com.pramodvaddiraju.TaskVerse.entity.Task;
import com.pramodvaddiraju.TaskVerse.exception.ResourceNotFoundException;
import com.pramodvaddiraju.TaskVerse.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper){
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }





    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = modelMapper.map(taskRequestDto, Task.class);
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    @Override
    public Page<TaskResponseDto> getAllTasks(Pageable pageable) {

        return taskRepository.findAll(pageable).map(task -> modelMapper.map(task, TaskResponseDto.class));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        Task getById =  taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Task not found by id: " + id)
        );
        return modelMapper.map(getById, TaskResponseDto.class);
    }

    @Override
    public void deleteTaskById(Long id) {

        taskRepository.deleteById(id);
    }
}
