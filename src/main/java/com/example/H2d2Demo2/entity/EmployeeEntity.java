package com.example.H2d2Demo2.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String designation;
    @Column
    private int salary;
    @Column
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy= "employeeEntity", cascade = CascadeType.ALL)
    private List<EmployeeHolidaysEntity> employeeHolidays;

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


    public List<EmployeeHolidaysEntity> getEmployeeHolidays() {
        return employeeHolidays;
    }

    public void setEmployeeHolidays(List<EmployeeHolidaysEntity> employeeHolidays) {
        this.employeeHolidays = employeeHolidays;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", employeeHolidays=" + employeeHolidays +
                '}';
    }
}
