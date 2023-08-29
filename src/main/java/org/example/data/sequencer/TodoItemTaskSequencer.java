package org.example.data.sequencer;

public class TodoItemTaskSequencer {

    private static int todoItemTaskSequencer;

    public static int nextId() {
        return ++todoItemTaskSequencer;
    }

    public static int getTodoItemTaskSequencer() {
        return todoItemTaskSequencer;
    }

    public static void setTodoItemTaskSequencer(int newTodoItemTaskSequencer) {
        todoItemTaskSequencer = newTodoItemTaskSequencer;
    }


}
