package com.hospital.healthcare.service.impl;

import com.hospital.healthcare.entity.Appointment;
import com.hospital.healthcare.exception.ResourceNotFoundException;
import com.hospital.healthcare.repository.AppointmentRepository;
import com.hospital.healthcare.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment scheduleAppointment(Appointment appointment) {
        logger.info("Scheduling new appointment for patient ID: {} with doctor ID: {}", 
                appointment.getPatient() != null ? appointment.getPatient().getId() : "N/A", 
                appointment.getDoctor() != null ? appointment.getDoctor().getId() : "N/A");
        return appointmentRepository.save(appointment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointments() {
        logger.info("Fetching all appointments from database.");
        return appointmentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Appointment> getAppointmentById(Long id) {
        logger.info("Fetching appointment with id: {}", id);
        return Optional.of(appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id)));
    }

    @Override
    public void deleteAppointment(Long id) {
        logger.info("Deleting appointment with id: {}", id);
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        appointmentRepository.delete(existingAppointment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        logger.info("Fetching appointments for patient ID: {}", patientId);
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        logger.info("Fetching appointments for doctor ID: {}", doctorId);
        return appointmentRepository.findByDoctorId(doctorId);
    }
}