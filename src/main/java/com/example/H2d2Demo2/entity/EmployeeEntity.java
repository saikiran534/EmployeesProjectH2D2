package com.example.H2d2Demo2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EmployeeEntity")
public class    EmployeeEntity implements Serializable {
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


    @JsonManagedReference
    //@JoinColumn(referencedColumnName = "employeeId")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = EmployeeHolidaysEntity.class)

    private List<EmployeeHolidaysEntity> employeeHolidayEntities;
//    @JsonManagedReference
//    @OneToOne(cascade = CascadeType.ALL)


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

    public List<EmployeeHolidaysEntity> getEmployeeHolidayEntities() {
        return employeeHolidayEntities;
    }

    public void setEmployeeHolidayEntities(List<EmployeeHolidaysEntity> employeeHolidayEntities) {
        this.employeeHolidayEntities = employeeHolidayEntities;
    }
}
