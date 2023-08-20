package org.example.model;

import java.util.Objects;

public class Person {


    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private String fullName;

    //private String summary;

    private AppUser credentials;


    private Person() {
        this.id = PersonSequencer.getNextId();
    }

    public Person(String firstName, String lastName, String email) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    /*
    public String toString1() {
        return "First Name: " + firstName + " Last Name: " + lastName + " email: " + email;
    }
    */

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

    /*
    public String getSummary() {
        return "Person{ Id = " + id + ", firstName = '" + firstName + "', lastName = '" + lastName +
                "', email = '" + email + "'}";
    }
    */

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
