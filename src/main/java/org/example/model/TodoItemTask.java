package org.example.model;

import org.example.data.sequencer.TodoItemTaskSequencer;

import java.util.Objects;


public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    //private String summary;


    private TodoItemTask() {
        this.id = TodoItemTaskSequencer.nextId();
    }

    public TodoItemTask(boolean assigned, TodoItem todoItem, Person assignee) {
        this();
        setAssigned(assigned);
        setTodoItem(todoItem);
        setAssignee(assignee);
    }

    public TodoItemTask(int id, boolean assigned, TodoItem todoItem, Person assignee) {
        setId(id);
        setAssigned(assigned);
        setTodoItem(todoItem);
        setAssignee(assignee);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TodoItemTask task = (TodoItemTask) obj;
        return id == task.id && assigned == task.assigned && Objects.equals(todoItem, task.todoItem);
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +                     // 'todoItem.getId()' will print only the ID of the associated TodoItem
                ", assignee=" + assignee +
                '}';
    }
}
