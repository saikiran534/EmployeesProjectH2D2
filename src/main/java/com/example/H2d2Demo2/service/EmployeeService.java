package com.example.H2d2Demo2.service;

import com.example.H2d2Demo2.entity.CompanyConfigEntity;
import com.example.H2d2Demo2.entity.EmployeeEntity;
import com.example.H2d2Demo2.entity.EmployeeHolidaysEntity;
import com.example.H2d2Demo2.entity.PublicHolidaysEntity;
import com.example.H2d2Demo2.model.CompanyConflictModel;
import com.example.H2d2Demo2.model.EmployeeModel;
import com.example.H2d2Demo2.model.PublicHolidayModel;
import com.example.H2d2Demo2.repository.CompanyConfigRepo;
import com.example.H2d2Demo2.repository.EmployeeRepo;
import com.example.H2d2Demo2.repository.PublicHolidaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public EmployeeEntity addDetails(EmployeeModel employeeModel){
        EmployeeEntity entity = new EmployeeEntity();
        List<EmployeeHolidaysEntity> holidays = new ArrayList<>();

        employeeModel.getEmployeeHolidays().stream().forEach(data -> {
            EmployeeHolidaysEntity holidaysEntity = new EmployeeHolidaysEntity();
            holidaysEntity.setFromDate(data.getFromDate());
            holidaysEntity.setToDate(data.getToDate());
            holidaysEntity.setDescription(data.getDescription());
            holidaysEntity.setEmployeeEntity(entity);
            holidays.add(holidaysEntity);
        });
        entity.setEmployeeHolidays(holidays);
        entity.setName(employeeModel.getName());
        entity.setEmail(employeeModel.getEmail());
        entity.setDesignation(employeeModel.getDesignation());
        entity.setSalary(employeeModel.getSalary());
        entity.setAddress(employeeModel.getAddress());
//        entity.getHolidaysEntityList().stream().forEach(x->System.out.println(x.getDescription()));
//        System.out.println(entity.toString());
        return employeeRepo.save(entity);
    }
    @Autowired
    private PublicHolidaysRepo pHolidayRepo;
    public PublicHolidaysEntity addPublicHolidays( PublicHolidayModel publicHolidayModel)
    {

        PublicHolidaysEntity pEntity = new PublicHolidaysEntity();
        pEntity.setDate(publicHolidayModel.getDate());
        pEntity.setDescription(publicHolidayModel.getDescription());
//        employeeRepo.findAll().stream().forEach(m->m.getHolidaysEntityList().stream().forEach(x->x.getDescription()));
        return pHolidayRepo.save(pEntity);
    }

    @Autowired
    private CompanyConfigRepo companyRepo;

    public CompanyConfigEntity addCompanyConfig(CompanyConflictModel companyConfigModel)
    {
        CompanyConfigEntity cEntity = new CompanyConfigEntity();
        cEntity.setNumberOfHolidays(companyConfigModel.getNoOfHolidays());
        cEntity.setWorkingHours(companyConfigModel.getWorkingHours());
        return companyRepo.save(cEntity);
    }




    public List<EmployeeEntity> getDetails()
    {

        return employeeRepo.findAll();
    }


    public EmployeeEntity getById(int id)
    {
        Optional<EmployeeEntity> entity = employeeRepo.findById(id);
        if (entity.isPresent())
        {
//            System.out.println(pHolidayRepo.findAll());
//            System.out.println(companyRepo.findAll());
//            System.out.println(employeeRepo.findAll());
            return employeeRepo.getById(id);
        }
        return null;

    }
}
