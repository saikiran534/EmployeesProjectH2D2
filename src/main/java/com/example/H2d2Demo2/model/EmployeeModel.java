package com.example.H2d2Demo2.model;

import com.example.H2d2Demo2.entity.CompanyConfigEntity;

import java.util.List;
import java.util.Optional;

public class EmployeeModel {
    private int id;
    private String name;
    private String email;
    private String designation;
    private int salary;
    private String address;
    private List<EmployeeHolidayModel> employeeHolidays;
    private List<PublicHolidayModel> publicHolidays;
    private List<CompanyConflictModel> companyConfig;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<PublicHolidayModel> getPublicHolidays() {
        return publicHolidays;
    }

    public void setPublicHolidays(List<PublicHolidayModel> publicHolidays) {
        this.publicHolidays = publicHolidays;
    }

    public List<CompanyConflictModel> getCompanyConfig() {
        return companyConfig;
    }

    public void setCompanyConfig(List<CompanyConflictModel> companyConfig) {
        this.companyConfig = companyConfig;
    }
}
