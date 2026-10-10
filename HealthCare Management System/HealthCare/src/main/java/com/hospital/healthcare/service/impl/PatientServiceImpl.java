package com.hospital.healthcare.service.impl;

import com.hospital.healthcare.entity.Patient;
import com.hospital.healthcare.exception.ResourceNotFoundException;
import com.hospital.healthcare.repository.PatientRepository;
import com.hospital.healthcare.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        logger.info("Saving new patient: {}", patient.getName());
        return patientRepository.save(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        logger.info("Fetching all patients from database.");
        return patientRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> getPatientById(Long id) {
        logger.info("Fetching patient with id: {}", id);
        return Optional.of(patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id)));
    }

    @Override
    public Patient updatePatient(Long id, Patient patientDetails) {
        logger.info("Updating patient with id: {}", id);
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        existingPatient.setName(patientDetails.getName());
        existingPatient.setDob(patientDetails.getDob());
        existingPatient.setGender(patientDetails.getGender());
        existingPatient.setContact(patientDetails.getContact());
        existingPatient.setAddress(patientDetails.getAddress());

        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(Long id) {
        logger.info("Deleting patient with id: {}", id);
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(existingPatient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patient> getPatientsByGender(String gender) {
        logger.info("Fetching patients by gender: {}", gender);
        return patientRepository.findPatientsByGender(gender);
    }
}