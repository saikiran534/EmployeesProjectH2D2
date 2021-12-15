package com.example.H2d2Demo2.model;

public class SalaryModel {
    private int Id;
    private String name;

    private int monthlySalary;
    private int yearlyPackage;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
