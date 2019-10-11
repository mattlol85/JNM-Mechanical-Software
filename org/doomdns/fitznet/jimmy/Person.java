package org.doomdns.fitznet.jimmy;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    //No Arg
    public Person() {
    
        firstName = "";
        lastName = "";
        email = "";
    }
    //With Arg
    public Person(String firstName, String lastName, String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Getters

    String getFirstname(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }

    String getEmail(){
        return email;
    }

    //Setters
    void setFirstName(String firstName){
        this.firstName = firstName;
    }

    void setLastName(String lastName){
        this.lastName = lastName;
    }

    void setEmail(String email){
        this.email = email;
    }

}