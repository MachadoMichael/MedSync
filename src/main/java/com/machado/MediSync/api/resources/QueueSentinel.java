package com.machado.MediSync.api.resources;


import com.machado.MediSync.api.appointment.entities.Appointment;
import com.machado.MediSync.api.appointment.services.AppointmentService;
import com.machado.MediSync.api.patient.enums.RiskRank;
import com.machado.MediSync.api.patient.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class QueueSentinel {

    @Autowired
    AppointmentService appointmentService;

    private List<Appointment> riskClassification;
    private List<Appointment> waitingForService;


    @Scheduled(fixedRate = 5000)
    public void checkQueue() {
        List<Appointment> appointments = appointmentService.getAll().stream()
                .filter(appointment -> !appointment.getStatus().equals(Status.FINISHED)).toList();

        if (!appointments.isEmpty()) {

            List<Appointment> queueRisk = appointments.stream()
                    .filter(appointment -> appointment.getStatus().equals(Status.RISK_CLASSIFICATION)).toList();

            riskClassificationQueueManager(queueRisk);


            List<Appointment> queueService = appointments.stream()
                    .filter(appointment -> appointment.getStatus().equals(Status.WAITING_FOR_SERVICE)).toList();

            serviceQueueManager(queueService);
        }
    }

    public void riskClassificationQueueManager(List<Appointment> appointments) {
        appointments.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));
        riskClassification = appointments;
    }

    public void serviceQueueManager(List<Appointment> appointments) {
        List<Appointment> criticalQueue = new ArrayList<>(appointments.stream()
                .filter(appointment -> appointment.getRiskRank().equals(RiskRank.CRITICAL_EMERGENCY)).toList());
        criticalQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        List<Appointment> urgentQueue = new ArrayList<>(appointments.stream()
                .filter(appointment -> appointment.getRiskRank().equals(RiskRank.URGENT_EMERGENCY)).toList());
        urgentQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        List<Appointment> importantQueue = new ArrayList<>(appointments.stream()
                .filter(appointment -> appointment.getRiskRank().equals(RiskRank.IMPORTANT_EMERGENCY)).toList());
        importantQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        List<Appointment> UrgencyQueue = new ArrayList<>(appointments.stream()
                .filter(appointment -> appointment.getRiskRank().equals(RiskRank.URGENCY)).toList());
        UrgencyQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        List<Appointment> nonUrgentQueue = new ArrayList<>(appointments.stream()
                .filter(appointment -> appointment.getRiskRank().equals(RiskRank.NON_URGENT)).toList());
        nonUrgentQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        List<Appointment> newQueue = new ArrayList<>();

        newQueue.addAll(criticalQueue);
        newQueue.addAll(urgentQueue);
        newQueue.addAll(importantQueue);
        newQueue.addAll(UrgencyQueue);
        newQueue.addAll(nonUrgentQueue);

        waitingForService = newQueue;
    }
}