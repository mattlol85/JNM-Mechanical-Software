package org.doomdns.fitznet.jimmy;

import java.io.Serializable;

public class Person implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -7229712354441884402L;
    private String firstName;
    private String lastName;
    private String email;

    // No Arg
    public Person() {

        firstName = "";
        lastName = "";
        email = "";
    }

    // With Arg
    public Person(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters

    String getFirstname() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getEmail() {
        return email;
    }

    // Setters
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String str = String.format("%-10s%-15s%-20s", firstName, lastName, email);
        return str;
    }
}