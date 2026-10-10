package com.hospital.healthcare.service.impl;

import com.hospital.healthcare.entity.Doctor;
import com.hospital.healthcare.exception.ResourceNotFoundException;
import com.hospital.healthcare.repository.DoctorRepository;
import com.hospital.healthcare.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        logger.info("Saving new doctor: {}", doctor.getName());
        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getAllDoctors() {
        logger.info("Fetching all doctors from database.");
        return doctorRepository.findAll();
    }
 
    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> getDoctorById(Long id) {
        logger.info("Fetching doctor with id: {}", id);
        return Optional.of(doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id)));
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        logger.info("Updating doctor with id: {}", id);
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

        existingDoctor.setName(doctorDetails.getName());
        existingDoctor.setSpecialization(doctorDetails.getSpecialization());
        existingDoctor.setPhone(doctorDetails.getPhone());
        existingDoctor.setEmail(doctorDetails.getEmail());

        return doctorRepository.save(existingDoctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        logger.info("Deleting doctor with id: {}", id);
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));
        doctorRepository.delete(existingDoctor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        logger.info("Fetching doctors by specialization: {}", specialization);
        return doctorRepository.findBySpecialization(specialization);
    }
}