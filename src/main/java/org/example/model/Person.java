package org.example.model;

public class Person {


    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private String fullName;
    private String summary;


    private Person() {
        this.id = PersonSequencer.getNextId();
    }

    public Person(String firstName, String lastName, String email) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }


//    public Person(String firstName, String lastName) {
//        this();
//        getSummary();
//    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName cannot be null");
        }
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("email cannot be null");
        }
        this.email = email;
    }

    public String getSummary() {
        return "Person{ Id = " + id + ", firstName = '" + firstName + "', lastName = '" + lastName +
                "', email = '" + email + "'}";
    }

}
