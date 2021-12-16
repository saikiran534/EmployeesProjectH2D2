package com.example.H2d2Demo2.model;

import java.time.LocalDate;
import java.time.Period;

public class EmployeeHolidayModel {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String description;
    private long noOfDays;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(long noOfDays) {
        this.noOfDays = noOfDays;
    }

    @Override
    public String toString() {
        return "EmployeeHolidayModel{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", description='" + description + '\'' +
                ", noOfDays=" + noOfDays +
                '}';
    }
}
