package org.example.data.dao;

import org.example.data.sequencer.TodoItemTaskSequencer;
import org.example.model.Person;
import org.example.model.TodoItemTask;

import java.util.Collection;
import java.util.HashSet;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    private final Collection<TodoItemTask> todoItemTasks = new HashSet<>();

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if (todoItemTask == null) {
            throw new IllegalArgumentException("TodoItemTask cannot be null");
        }
        int id = TodoItemTaskSequencer.nextId();
        todoItemTask.setId(id);
        todoItemTasks.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask task : todoItemTasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new HashSet<>(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findAllByAssignedStatus(boolean status) {
        Collection<TodoItemTask> tasksWithStatus = new HashSet<>();
        for (TodoItemTask task : todoItemTasks) {
            if (task.isAssigned() == status) {
                tasksWithStatus.add(task);
            }
        }
        return tasksWithStatus;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> taskForPerson = new HashSet<>();
        for (TodoItemTask task : todoItemTasks) {
            Person assignee = task.getAssignee();
            if (assignee != null && assignee.getId() == personId) {
                taskForPerson.add(task);
            }
        }
        return taskForPerson;
    }

    @Override
    public void remove(int id) {
        TodoItemTask taskToRemove = null;
        for (TodoItemTask task : todoItemTasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove != null) {
            todoItemTasks.remove(taskToRemove);
        }
    }
}
