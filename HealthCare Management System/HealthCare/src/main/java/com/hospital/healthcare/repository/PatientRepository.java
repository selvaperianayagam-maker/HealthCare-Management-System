package com.hospital.healthcare.repository;

import com.hospital.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    
    @Query("SELECT p FROM Patient p WHERE p.gender = :gender")
    List<Patient> findPatientsByGender(@Param("gender") String gender);

    
    @Query(value = "SELECT * FROM patients WHERE contact = :contact", nativeQuery = true)
    Patient findByContactNumber(@Param("contact") String contact);
}