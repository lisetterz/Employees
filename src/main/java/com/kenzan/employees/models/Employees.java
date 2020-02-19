package com.kenzan.employees.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employees {
    @Id
    public ObjectId ID;
    private String FirstName;
    private String MiddleInitial; //could be char
    private String LastName;
    private String DateOfBirth; //could be date
    private String DateOfEmployment; //could be date
    private String Status = "ACTIVE"; //Active or Innactive

    public Employees(){

    }
    public Employees(ObjectId ID, String FirstName, String MiddleInitial, String LastName, String DateOfBirth,
                     String DateOfEmployment, String Status){
        this.setID(ID);
        this.setFirstName(FirstName);
        this.setMiddleInitial(MiddleInitial);
        this.setLastName(LastName);
        this.setDateOfBirth(DateOfBirth);
        this.setDateOfEmployment(DateOfEmployment);
        this.setStatus(Status);
    }


    public String getID() {
        return ID.toHexString();
    }

    public void setID(ObjectId ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleInitial() {
        return MiddleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        MiddleInitial = middleInitial;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDateOfEmployment() {
        return DateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        DateOfEmployment = dateOfEmployment;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


}

