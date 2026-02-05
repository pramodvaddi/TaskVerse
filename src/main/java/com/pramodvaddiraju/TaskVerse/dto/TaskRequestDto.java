package com.pramodvaddiraju.TaskVerse.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class TaskRequestDto {

    @NotBlank(message = "Title field must not be null")
    private String title;

    @NotBlank(message = "Description field must not be null")
    private String description;

    @NotBlank(message = "Priority must set")
    private String priority;

    private int internalScore;


    public TaskRequestDto(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getInternalScore() {
        return internalScore;
    }

    public void setInternalScore(int internalScore) {
        this.internalScore = internalScore;
    }
}
