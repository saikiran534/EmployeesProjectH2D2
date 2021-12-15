package com.example.H2d2Demo2.entity;

import javax.persistence.*;

@Entity
@Table(name = "salaryTable")
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int monthlySalary;
    @Column
    private int yearlyPackage;

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

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getYearlyPackage() {
        return yearlyPackage;
    }

    public void setYearlyPackage(int yearlyPackage) {
        this.yearlyPackage = yearlyPackage;
    }
}
