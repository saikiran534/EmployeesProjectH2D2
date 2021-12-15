package com.example.H2d2Demo2.model;

import java.util.List;

public class EmployeeModel {
    private int employeeId;
    private String name;
    private String email;
    private String designation;
    private int salary;
    private String address;
    private List<EmployeeHolidayModel> employeeHolidays;


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EmployeeHolidayModel> getEmployeeHolidays() {
        return employeeHolidays;
    }

    public void setEmployeeHolidays(List<EmployeeHolidayModel> employeeHolidays) {
        this.employeeHolidays = employeeHolidays;
    }
}
