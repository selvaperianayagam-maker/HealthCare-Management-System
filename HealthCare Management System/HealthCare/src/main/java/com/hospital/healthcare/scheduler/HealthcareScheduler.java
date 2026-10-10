package com.hospital.healthcare.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class HealthcareScheduler {

    private static final Logger logger = LoggerFactory.getLogger(HealthcareScheduler.class);

    
    @Scheduled(fixedRate = 60000)
    public void performScheduledTask() {
        logger.info("Healthcare System Scheduler - Background task executed at: {}", LocalDateTime.now());
    }

    
    @Scheduled(cron = "0 0/30 * * * *")
    public void checkPendingAppointments() {
        logger.info("Healthcare Scheduler - Checking for pending or upcoming appointments at: {}", LocalDateTime.now());
        
    }
}