package com.example.H2d2Demo2.controller;


import com.example.H2d2Demo2.entity.EmployeeEntity;
import com.example.H2d2Demo2.model.CompanyConflictModel;
import com.example.H2d2Demo2.model.EmployeeModel;
import com.example.H2d2Demo2.model.PublicHolidayModel;
import com.example.H2d2Demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add-details")
    public EmployeeEntity addData(@RequestBody EmployeeModel employeeModel)
    {
    return employeeService.addDetails(employeeModel);
    }

    @PostMapping("/add-publicholidays")
    public void addPholidays(@RequestBody PublicHolidayModel holidayModel)
    {
        employeeService.addPublicHolidays(holidayModel);
    }
    @PostMapping("/add-companyconfig")
    public void addCompany(@RequestBody CompanyConflictModel companyConfig)
    {
        employeeService.addCompanyConfig(companyConfig);
    }
    @RequestMapping("/get-details")
    public List<EmployeeEntity> getDetails()
    {
        return employeeService.getDetails();
    }

    @RequestMapping("/getby-id/{id}")
    public EmployeeEntity getById(@PathVariable int id)
    {
        return employeeService.getById(id);


    }



}
