package com.hospital.healthcare.repository;

import com.hospital.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    
    List<Doctor> findBySpecialization(String specialization);

    
    @Query("SELECT d FROM Doctor d WHERE d.email = :email")
    Doctor findDoctorByEmailAddress(@Param("email") String email);
}