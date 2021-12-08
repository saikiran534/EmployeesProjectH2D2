package com.example.H2d2Demo2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Company_Configuration")
public class CompanyConfigEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int numberOfHolidays;
    @Column
    private int workingHours;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)

    @JoinColumn(name = "Name",referencedColumnName = "name")
//    @JsonIgnoreProperties("companyConfig")
    @JsonBackReference

    private EmployeeEntity employeeEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfHolidays() {
        return numberOfHolidays;
    }

    public void setNumberOfHolidays(int numberOfHolidays) {
        this.numberOfHolidays = numberOfHolidays;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

}
