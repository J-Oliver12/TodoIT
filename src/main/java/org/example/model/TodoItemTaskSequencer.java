package org.example.model;

public class TodoItemTaskSequencer {

    private static int sequencer = 0;

    public static int getNextId(){
        return ++sequencer;
    }

}
