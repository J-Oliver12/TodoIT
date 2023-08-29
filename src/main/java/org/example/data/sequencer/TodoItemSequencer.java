package org.example.data.sequencer;

public class TodoItemSequencer {


        private static int todoItemSequencer;

        public static int nextId() {
            return ++todoItemSequencer;
        }

        public static int getTodoItemSequencer() {
            return todoItemSequencer;
        }

        public static void setTodoItemSequencer(int newTodoItemSequencer) {
            todoItemSequencer = newTodoItemSequencer;
        }

}
