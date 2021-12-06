package com.example.H2d2Demo2.repository;

import com.example.H2d2Demo2.entity.PublicHolidaysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicHolidaysRepo extends JpaRepository<PublicHolidaysEntity, Integer> {
}
