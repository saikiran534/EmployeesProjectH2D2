package com.example.H2d2Demo2.service;
import com.example.H2d2Demo2.entity.*;
import com.example.H2d2Demo2.model.*;
import com.example.H2d2Demo2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private SalaryRepo salaryRepo;
    @Autowired
    private PublicHolidaysRepo publicHolidayRepo;
    @Autowired
    private CompanyConfigRepo companyConfigurationRepo;
    @Autowired
    private EmployeeHolidaysRepo holidaysRepo;
   ///**List Conversion to model **///
   ///To get Converted List of EmployeeHoliday out from the stream we need to take an empty list before writing the stream ///
   public EmployeeEntity addDetails(EmployeeModel employeeModel) {
       EmployeeEntity entity = new EmployeeEntity();

        List<EmployeeEntity> check = employeeRepo.findAll();


           List<EmployeeHolidaysEntity> empEntity = new ArrayList<>();
           employeeModel.getEmployeeHolidays().stream().forEach(x ->
           {
               EmployeeHolidaysEntity holidayEntity = new EmployeeHolidaysEntity();
               holidayEntity.setFromDate(x.getFromDate());
               holidayEntity.setToDate(x.getToDate());
               holidayEntity.setDescription(x.getDescription());
               holidayEntity.setEmployeeEntity(entity);

               empEntity.add(holidayEntity);
           });

           entity.setName(employeeModel.getName());
           entity.setEmail(employeeModel.getEmail());
           entity.setDesignation(employeeModel.getDesignation());
           entity.setSalary(employeeModel.getSalary());
           entity.setAddress(employeeModel.getAddress());
           entity.setEmployeeHolidays(empEntity);

           return employeeRepo.save(entity);
       }


    public PublicHolidaysEntity addPHoliday(PublicHolidayModel publicHolidayModel)
    {
        PublicHolidaysEntity holiday = new PublicHolidaysEntity();
        holiday.setDate(publicHolidayModel.getDate());
        holiday.setDescription(publicHolidayModel.getDescription());
        return publicHolidayRepo.save(holiday);
    }

    public CompanyConfigEntity addCompany(CompanyConfigModel companyConfigModel)
    {
        CompanyConfigEntity company = new CompanyConfigEntity();
        company.setNumberOfHolidays(companyConfigModel.getNoOfHolidays());
        company.setWorkingHours(companyConfigModel.getWorkingHours());
        return companyConfigurationRepo.save(company);
    }

    public List<EmployeeModel> getId(int id)
    {
        Optional<EmployeeEntity> eEntity = employeeRepo.findById(id);
        if(eEntity.isPresent())
        {
            Optional<EmployeeEntity> employeeEntityList = employeeRepo.findById(id);
            List<EmployeeModel> eModel = new ArrayList<>();
            return employeeEntityList.stream().map(details->modelToEntity(details)).collect(Collectors.toList());

        }
        return null;
    }
    public List<EmployeeModel> getall() {
        List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
        List<EmployeeModel> eModel = new ArrayList<>();
        return employeeEntityList.stream().map(value->modelToEntity(value)).collect(Collectors.toList());
    }

    public List<PublicHolidayModel> getPublicHolidays() {
        List<PublicHolidaysEntity> holidayEntity = publicHolidayRepo.findAll();
        return holidayEntity.stream().map(details->holidayModeltoEntity(details)).collect(Collectors.toList());

    }


    public List<CompanyConfigModel> getcompany() {
        List<CompanyConfigEntity> config = companyConfigurationRepo.findAll();
        List<CompanyConfigModel>  compModel = new ArrayList<>();
        config.stream().forEach(value ->
                {
                    CompanyConfigModel model = new CompanyConfigModel();
                    model.setNoOfHolidays(value.getNumberOfHolidays());
                    model.setWorkingHours(value.getWorkingHours());
                    compModel.add(model);
                }
        );
        return compModel;
    }
    public PublicHolidayModel holidayModeltoEntity(PublicHolidaysEntity holidayEntity)
    {
        PublicHolidayModel holidayModel = new PublicHolidayModel();
        holidayModel.setDate(holidayModel.getDate());
        holidayModel.setDescription(holidayEntity.getDescription());
        return holidayModel;

    }

    public EmployeeModel modelToEntity(EmployeeEntity entity)
    {
        EmployeeModel model = new EmployeeModel();
        model.setEmployeeId(entity.getEmployeeId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());
        model.setDesignation(entity.getDesignation());
        model.setSalary(entity.getSalary());
        model.setDesignation(entity.getAddress());


        List<EmployeeHolidayModel> holidayModel = new ArrayList<>();
        entity.getEmployeeHolidays().stream().forEach(value->
        {
            EmployeeHolidayModel hModel = new EmployeeHolidayModel();
            hModel.setFromDate(value.getFromDate());
            hModel.setToDate(value.getToDate());
            hModel.setDescription(value.getDescription());
            model.setEmployeeHolidays(holidayModel);
            holidayModel.add(hModel);
        });
        return model;
    }

    public SalaryEntity addSalary(SalaryModel salaryModel) {
       SalaryEntity sEntity = new SalaryEntity();
       sEntity.setId(salaryModel.getId());
       sEntity.setName(salaryModel.getName());
       sEntity.setMonthlySalary(salaryModel.getMonthlySalary());
       sEntity.setYearlyPackage(salaryModel.getYearlyPackage());
       return salaryRepo.save(sEntity);
    }
    public SalaryModel conversion(SalaryEntity salaryEntity)
    {
        SalaryModel model = new SalaryModel();
        model.setId(salaryEntity.getId());
        model.setName(salaryEntity.getName());
        model.setMonthlySalary(salaryEntity.getMonthlySalary());
        model.setYearlyPackage(salaryEntity.getYearlyPackage());
        return model;
    }
    public List<SalaryModel> getSalary() {
        List<SalaryEntity> sEntity = salaryRepo.findAll();
        return sEntity.stream().map(value->conversion(value)).collect(Collectors.toList());
    }
    public List<SalaryModel> getSalaryById(String name) {
        List<SalaryEntity> idEntity = salaryRepo.findAll();
        return idEntity.stream().filter(value-> value.getName().equals(name)).map(info->conversion(info)).collect(Collectors.toList());
    }

    public long date(int id ) {
       Optional<EmployeeEntity> data = employeeRepo.findById(id);
       List<EmployeeModel> sai = data.stream().map(value-> modelToEntity(value)).collect(Collectors.toList());
       List<String> fromList = new ArrayList();
       List<String > toList = new ArrayList();
       sai.stream().forEach(value->{
           value.getEmployeeHolidays().stream().forEach(x->{
               fromList.add(x.getFromDate());
           });
       });
       sai.stream().forEach(value->
       {
           value.getEmployeeHolidays().stream().forEach(y->
           {
               toList.add(y.getToDate());
           });
       });
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String s1 = fromList.toString();
        String s2 = toList.toString();
        LocalDate d1 =LocalDate.parse(s1,formatter_1);
        LocalDate d2 = LocalDate.parse(s2,formatter_1);
        long deference = ChronoUnit.DAYS.between(d1,d2);
       return deference;
    }
}