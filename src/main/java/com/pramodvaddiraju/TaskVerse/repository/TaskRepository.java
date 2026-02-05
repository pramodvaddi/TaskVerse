package com.pramodvaddiraju.TaskVerse.repository;

import com.pramodvaddiraju.TaskVerse.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {



}
