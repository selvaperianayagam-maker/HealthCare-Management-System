package com.hospital.healthcare.service;

import com.hospital.healthcare.entity.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    Patient updatePatient(Long id, Patient patientDetails);
    void deletePatient(Long id);
    List<Patient> getPatientsByGender(String gender);
}