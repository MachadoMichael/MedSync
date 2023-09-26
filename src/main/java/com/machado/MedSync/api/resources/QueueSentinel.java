package com.machado.MedSync.api.resources;


import com.machado.MedSync.api.appointment.entities.Appointment;
import com.machado.MedSync.api.appointment.services.AppointmentService;
import com.machado.MedSync.api.patient.enums.RiskRank;
import com.machado.MedSync.api.patient.enums.Status;
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
        List<Appointment> criticalQueue = sortedQueue(appointments, RiskRank.CRITICAL_EMERGENCY);
        List<Appointment> urgentQueue = sortedQueue(appointments, RiskRank.URGENT_EMERGENCY);
        List<Appointment> importantQueue = sortedQueue(appointments, RiskRank.IMPORTANT_EMERGENCY);
        List<Appointment> UrgencyQueue = sortedQueue(appointments, RiskRank.URGENCY);
        List<Appointment> nonUrgentQueue = sortedQueue(appointments, RiskRank.NON_URGENT);

        List<Appointment> newQueue = new ArrayList<>();

        newQueue.addAll(criticalQueue);
        newQueue.addAll(urgentQueue);
        newQueue.addAll(importantQueue);
        newQueue.addAll(UrgencyQueue);
        newQueue.addAll(nonUrgentQueue);

        waitingForService = newQueue;
    }

    public List<Appointment> sortedQueue(List<Appointment> queue, RiskRank riskRank){

        List<Appointment> sortedQueue = new ArrayList<>(queue.stream()
                .filter(appointment -> appointment.getRiskRank().equals(riskRank)).toList());
        sortedQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        return sortedQueue;
    }
}