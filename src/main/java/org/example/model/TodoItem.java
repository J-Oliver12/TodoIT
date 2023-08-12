package org.example.model;

import org.example.model.Person;

import java.time.LocalDate;

public class TodoItem {


    private final int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private boolean overdue;

    private String summary;


    private TodoItem() {
        this.id = TodoItemSequencer.getNextId();
    }


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("title cannot be null");
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) {
            throw new IllegalArgumentException("deadLine cannot be null");
        }

        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(deadLine)) {
            this.overdue = true;
        } else {
            this.overdue = false;
        }

        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public String getSummary() {
        String creatorName = (creator != null) ? creator.getFullName() : "Unknown";
        return "TodoItem{ Id = " + id + ", Title = '" + title + "', TaskDescription = '" + taskDescription +
                "', DeadLine = '" + deadLine.toString() + "', Done = '" + done + "', Creator = '" + creator + "', Overdue = '" +
                overdue + "'}";
    }

}
