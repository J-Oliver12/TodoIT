package org.example.model;

import org.example.model.Person;
import org.example.model.TodoItem;

import java.util.UUID;

public class TodoItemTask {

    private final int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;
    private String summary;


    private TodoItemTask() {
        this.id = TodoItemTaskSequencer.getNextId();
    }

    private TodoItemTask(boolean assigned, TodoItem todoItem, Person assignee) {
        this();
        setAssigned(assigned);
        setTodoItem(todoItem);
        setAssignee(assignee);
    }


    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("todoItem cannot be null");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    public String getSummary() {
        String assigneeName = (assignee != null) ? assignee.getFullName() : "Unassigned";
        return "TodoItemTask{ Id = " + id + ", Assigned = '" + assigned + "', TodoItem = '" +
                todoItem + "', Assignee = '" + assignee + "'}";
    }

}
