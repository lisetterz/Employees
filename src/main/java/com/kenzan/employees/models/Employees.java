package com.kenzan.employees.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employees {
    @Id
    public ObjectId id;
    private String firstName;
    private String middleInitial; //could be char
    private String lastName;
    private String dateOfBirth; //could be date
    private String dateOfEmployment; //could be date
    private String status = "ACTIVE"; //Active or Innactive

    public Employees(){

    }
    public Employees(ObjectId id, String firstName, String MiddleInitial, String LastName, String DateOfBirth,
                     String DateOfEmployment, String Status){
        this.setId(id);
        this.setFirstName(firstName);
        this.setMiddleInitial(MiddleInitial);
        this.setLastName(LastName);
        this.setDateOfBirth(DateOfBirth);
        this.setDateOfEmployment(DateOfEmployment);
        this.setStatus(Status);
    }


    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

