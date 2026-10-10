package com.hospital.healthcare.service;

import com.hospital.healthcare.entity.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Long id);
    Doctor updateDoctor(Long id, Doctor doctorDetails);
    void deleteDoctor(Long id);
    List<Doctor> getDoctorsBySpecialization(String specialization);
}