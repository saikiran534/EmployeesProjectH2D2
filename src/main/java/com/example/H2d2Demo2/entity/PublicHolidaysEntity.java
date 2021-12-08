package com.example.H2d2Demo2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publicHolidays")
public class PublicHolidaysEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String date;
    @Column
    private String description;

//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name ="Name",referencedColumnName = "name")
//   // @JsonIgnoreProperties("publicHolidays")
//    @JsonBackReference
// private EmployeeEntity employeeEntity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public EmployeeEntity getEmployeeEntity() {
//        return employeeEntity;
//    }
//
//    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
//        this.employeeEntity = employeeEntity;
//    }

}
