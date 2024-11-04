package com.example.todolist;

public class Task {
    private String name;
    private boolean isCompleted;

    public Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }


    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return name + (isCompleted ? " (completed)" : " (pending)");
    }
}
