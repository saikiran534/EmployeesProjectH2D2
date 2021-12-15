package com.example.H2d2Demo2.controller;
import com.example.H2d2Demo2.entity.EmployeeHolidaysEntity;
import com.example.H2d2Demo2.model.CompanyConfigModel;
import com.example.H2d2Demo2.model.EmployeeModel;
import com.example.H2d2Demo2.model.PublicHolidayModel;
import com.example.H2d2Demo2.model.SalaryModel;
import com.example.H2d2Demo2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @PostMapping("/add-public-holiday")
    public void addPublicHoliday(@RequestBody PublicHolidayModel publicHolidayModel)
    {
        employeeService.addPHoliday(publicHolidayModel);
    }
    @RequestMapping("/add-company-configurations")
    public void addCompanyConfigurations(@RequestBody CompanyConfigModel companyConfigModel)
    {
        employeeService.addCompany(companyConfigModel);
    }

    @RequestMapping("/get-public-holidays")
    public List<PublicHolidayModel> PublicHoliday()
    {
        return employeeService.getPublicHolidays();
    }
    @RequestMapping("get-allcompany")
    public List<CompanyConfigModel> getAllComp()
    {
        return employeeService.getcompany();
    }
    @RequestMapping("/get-byId/{id}")
    public List<EmployeeModel> getId(@PathVariable int id)
    {
        return employeeService.getId(id);
    }
    @RequestMapping("/get-all")
    public List<EmployeeModel> getall()
    {
        return employeeService.getall();
    }
    @RequestMapping("/add-salary")
    public void addSalary(@RequestBody SalaryModel salaryModel)
    {
        employeeService.addSalary(salaryModel);
    }
    @RequestMapping("/get-salary")
    public List<SalaryModel> getSalary()
    {
        return employeeService.getSalary();
    }
    @RequestMapping("get-by-salary-name/{name}")
    public List<SalaryModel> getById(@PathVariable String name)
    {
        return employeeService.getSalaryById(name);
    }

    @RequestMapping("/pending/{id}")
    public List pending(@PathVariable int id )
    {
        return employeeService.pendingLeaves(id);
    }
}