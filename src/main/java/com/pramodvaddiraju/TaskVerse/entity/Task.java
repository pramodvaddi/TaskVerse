package com.pramodvaddiraju.TaskVerse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Taskverse_data")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String priority;

    // hiding this from the user
    private int internalScore;


    public Task(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
