package com.example.contacts;

import javax.persistence.*;

@Entity
public class Friend {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String emailAddress;

    private String birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
}
