package com.example.dsuapp;

public class Faculties {

    String facultyName, facultyDept, facultyEmail, facultyPhoneNumber, facultyCabinNumber;

    public Faculties() {
    }

    public Faculties(String facultyName, String facultyDept, String facultyEmail, String facultyPhoneNumber, String facultyCabinNumber) {
        this.facultyName = facultyName;
        this.facultyDept = facultyDept;
        this.facultyEmail = facultyEmail;
        this.facultyPhoneNumber = facultyPhoneNumber;
        this.facultyCabinNumber = facultyCabinNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyDept() {
        return facultyDept;
    }

    public void setFacultyDept(String facultyDept) {
        this.facultyDept = facultyDept;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    public String getFacultyPhoneNumber() {
        return facultyPhoneNumber;
    }

    public void setFacultyPhoneNumber(String facultyPhoneNumber) {
        this.facultyPhoneNumber = facultyPhoneNumber;
    }

    public String getFacultyCabinNumber() {
        return facultyCabinNumber;
    }

    public void setFacultyCabinNumber(String facultyCabinNumber) {
        this.facultyCabinNumber = facultyCabinNumber;
    }
}
