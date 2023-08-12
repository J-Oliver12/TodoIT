package org.example.model;

public class TodoItemSequencer {

    private static int sequencer = 0;

    public static int getNextId(){
        return ++sequencer;
    }

}
