package com.example.H2d2Demo2.entity;

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
}
