package com.example.H2d2Demo2.service;
import com.example.H2d2Demo2.entity.CompanyConfigEntity;
import com.example.H2d2Demo2.entity.EmployeeEntity;
import com.example.H2d2Demo2.entity.EmployeeHolidaysEntity;
import com.example.H2d2Demo2.entity.PublicHolidaysEntity;
import com.example.H2d2Demo2.model.CompanyConflictModel;
import com.example.H2d2Demo2.model.EmployeeHolidayModel;
import com.example.H2d2Demo2.model.EmployeeModel;
import com.example.H2d2Demo2.model.PublicHolidayModel;
import com.example.H2d2Demo2.repository.CompanyConfigRepo;
import com.example.H2d2Demo2.repository.EmployeeHolidaysRepo;
import com.example.H2d2Demo2.repository.EmployeeRepo;
import com.example.H2d2Demo2.repository.PublicHolidaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.event.ListDataEvent;
import javax.xml.bind.annotation.W3CDomHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmployeeHolidaysRepo holidaysRepo;
    @Autowired
    private PublicHolidaysRepo publicHolidayRepo;
    @Autowired
    private CompanyConfigRepo companyConfigurationRepo;


    public EmployeeEntity addDetails(EmployeeModel employeeModel) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeModel.getName());
        entity.setEmail(employeeModel.getEmail());
        entity.setDesignation(employeeModel.getDesignation());
        entity.setSalary(employeeModel.getSalary());
        entity.setAddress(employeeModel.getAddress());

        ///**List Conversion to model **///
        ///To get Converted List of EmployeeHoliday out from the stream we need to take an empty list before writing the stream ///
        List<EmployeeHolidaysEntity> empEntity = new ArrayList<>();

        employeeModel.getEmployeeHolidays().stream().forEach(x->
        {
            EmployeeHolidaysEntity holidayEntity = new EmployeeHolidaysEntity();
            holidayEntity.setFromDate(x.getFromDate());
            holidayEntity.setToDate(x.getToDate());
            holidayEntity.setDescription(x.getDescription());
            holidayEntity.setEmployeeEntity(entity);
            empEntity.add(holidayEntity);

        });

        ///Now we need to set the employee Entity list to the main entity ///


        entity.setEmployeeHolidays(empEntity);

        ///*** now we need to convert PublicHolidayEntity List to Model ***\\\
        List<PublicHolidaysEntity> holidayList = new ArrayList<>();

        employeeModel.getPublicHolidays().stream().forEach(holiday->
        {
            PublicHolidaysEntity pEntity = new PublicHolidaysEntity();
            pEntity.setDate(holiday.getDate());
            pEntity.setDescription(holiday.getDescription());
            pEntity.setEmployeeEntity(entity);
            holidayList.add(pEntity);
        });


        entity.setPublicHolidays(holidayList);


        /// *** Company Configuration conversion ***\\\

        List<CompanyConfigEntity> companyList = new ArrayList<>();
        employeeModel.getCompanyConfig().stream().forEach(company->
                {
                    CompanyConfigEntity configList = new CompanyConfigEntity();
                    configList.setNumberOfHolidays(company.getNoOfHolidays());
                    configList.setWorkingHours(company.getWorkingHours());
                    configList.setEmployeeEntity(entity);
                    companyList.add(configList);
                });
        entity.setCompanyConfig(companyList);



        return employeeRepo.save(entity);
    }


    public List<EmployeeEntity> getDetails() {

        return employeeRepo.findAll();
    }


//    public EmployeeEntity getById(int id) {
//        Optional<EmployeeEntity> entity = employeeRepo.findById(id);
//        if (entity.isPresent()) {
//            return employeeRepo.getById(id);
//        }
//        return null;
//
//    }
    public List<EmployeeModel> getId(int id)
    {
        Optional<EmployeeEntity> eEntity = employeeRepo.findById(id);
        if(eEntity.isPresent())
        {
            List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
            List<EmployeeModel> eModel = new ArrayList<>();
            employeeEntityList.stream().forEach(eValue->
            {

                EmployeeModel empModel= new EmployeeModel();
                empModel.setName(eValue.getName());
                empModel.setEmail(eValue.getEmail());
                empModel.setDesignation(eValue.getDesignation());
                empModel.setSalary(eValue.getSalary());
                empModel.setAddress(eValue.getAddress());

                List<EmployeeHolidayModel> holidays= new ArrayList<>();
                List<EmployeeHolidaysEntity> empent=holidaysRepo.findAll();
                empent.stream().forEach(holiday->
                        {
                            EmployeeHolidayModel hModel = new EmployeeHolidayModel();
                            hModel.setFromDate(holiday.getFromDate());
                            hModel.setToDate(holiday.getToDate());
                            hModel.setDescription(holiday.getDescription());
                            holidays.add(hModel);

                        });
                empModel.setEmployeeHolidays(holidays);
                eModel.add(empModel);
            });
            return eModel;
        }
        return null;
    }
    public List<PublicHolidayModel> getPublicHolidays() {

        List<PublicHolidaysEntity> pEntity = publicHolidayRepo.findAll();
        List<PublicHolidayModel> pList = new ArrayList<>();
        pEntity.stream().forEach(pvalue-> {
            PublicHolidayModel pModel = new PublicHolidayModel();
            pModel.setDate(pvalue.getDate());
            pModel.setDescription(pvalue.getDescription());
            pList.add(pModel);

        });
        return pList;
    }


    public List<CompanyConflictModel> getcompany() {

        List<CompanyConfigEntity> config = companyConfigurationRepo.findAll();
        List<CompanyConflictModel>  compModel = new ArrayList<>();
        config.stream().forEach(value ->
                {
                    CompanyConflictModel model = new CompanyConflictModel();
                    model.setNoOfHolidays(value.getNumberOfHolidays());
                    model.setWorkingHours(value.getWorkingHours());
                    compModel.add(model);
                }
        );

        return compModel;




    }

}





















































