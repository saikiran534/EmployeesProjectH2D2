package com.example.H2d2Demo2.controller;


import com.example.H2d2Demo2.entity.CompanyConfigEntity;
import com.example.H2d2Demo2.entity.EmployeeEntity;
import com.example.H2d2Demo2.entity.PublicHolidaysEntity;
import com.example.H2d2Demo2.model.CompanyConflictModel;
import com.example.H2d2Demo2.model.EmployeeModel;
import com.example.H2d2Demo2.model.PublicHolidayModel;
import com.example.H2d2Demo2.repository.CompanyConfigRepo;
import com.example.H2d2Demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add-details")
    public void addData(@RequestBody EmployeeModel employeeModel)
    {
        employeeService.addDetails(employeeModel);
    }

    @RequestMapping("/get-details")
    public List<EmployeeEntity> Details()
    {
        return employeeService.getDetails();
    }


//    @RequestMapping("/get-by-id/{id}")
//    public EmployeeEntity getbyId(@PathVariable int id)
//    {
//        return employeeService.getById(id);
//    }

    @RequestMapping("/get-public-holidays")
    public List<PublicHolidayModel> PublicHoliday()
    {
        return employeeService.getPublicHolidays();
    }

    @RequestMapping("get-allcompany")
    public List<CompanyConflictModel> getAllComp()
    {
        return employeeService.getcompany();
    }
    @RequestMapping("/get-byId/{id}")
    public List<EmployeeModel> getId(@PathVariable int id)
    {
        return employeeService.getId(id);
    }







}
