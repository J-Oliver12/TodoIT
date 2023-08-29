package org.example.model;

import org.example.data.sequencer.TodoItemSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {


    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private boolean overdue;

    // private String summary;


    private TodoItem() {
        this.id = TodoItemSequencer.nextId();
    }


    public TodoItem(String title, String taskDescription, LocalDate deadLine, Person creator) {
        this();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);
    }

    public TodoItem(int id, String title, String taskDescription, LocalDate deadLine, Person creator) {
        setId(id);
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);
    }

    /*
    public String toString1() {
        return "Title: " + title + " Task Description: " + taskDescription + " Deadline: " + deadLine + " Creator: " + creator;
    }
    */
    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadline=" + deadLine +
                ", done=" + done +
                ", overdue=" + overdue +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (currentDate.isAfter (deadLine)) {
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

    /*
    public String getSummary() {
        String creatorName = (creator != null) ? creator.getFullName() : "Unknown";
        return "TodoItem{ Id = " + id + ", Title = '" + title + "', TaskDescription = '" + taskDescription +
                "', DeadLine = '" + deadLine.toString() + "', Done = '" + done + "', Creator = '" + creator + "', Overdue = '" +
                overdue + "'}";
    }
    */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TodoItem todoItem = (TodoItem)  obj;
        return  id == todoItem.id && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription,
                todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine) && done == todoItem.done &&
                overdue == todoItem.overdue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine, done, overdue);
    }

}
