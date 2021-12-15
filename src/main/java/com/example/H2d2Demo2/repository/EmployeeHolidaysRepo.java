package com.example.H2d2Demo2.repository;

import com.example.H2d2Demo2.entity.EmployeeHolidaysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeHolidaysRepo extends JpaRepository<EmployeeHolidaysEntity, Integer> {

}
