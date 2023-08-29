package org.example.data.sequencer;

public class PersonSequencer {

    private static int personSequencer;

    public static int nextId() {
        return ++personSequencer;
    }

    public static int getPersonSequencer() {
        return personSequencer;
    }

    public static void setPersonSequencer(int newPersonSequencer) {
        personSequencer = newPersonSequencer;
    }

}
