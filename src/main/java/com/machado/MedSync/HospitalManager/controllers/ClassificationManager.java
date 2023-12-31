package com.machado.MedSync.HospitalManager.controllers;

import com.machado.MedSync.HospitalManager.entities.SpecializationQueues;
import com.machado.MedSync.api.appointment.entities.Appointment;
import com.machado.MedSync.api.patient.enums.RiskRank;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassificationManager {

    private SpecializationQueues queues;

    @Scheduled(fixedRate = 5000)
    public void queueHandler() {
        QueuesSetter queuesSetter = new QueuesSetter();
        queuesSetter.checkQueue();
        SpecializationQueues queueSorted = scanQueues(queuesSetter.getSpecializationQueues());

    }


    private SpecializationQueues scanQueues(SpecializationQueues specializationQueues) {
        orderByProhibited(specializationQueues.getAnesthesiology());
        orderByProhibited(specializationQueues.getCardiology());
        orderByProhibited(specializationQueues.getDermatology());
        orderByProhibited(specializationQueues.getNeurology());
        orderByProhibited(specializationQueues.getGastroenterology());
        orderByProhibited(specializationQueues.getInternalMedicine());
        orderByProhibited(specializationQueues.getObstetricGynecology());
        orderByProhibited(specializationQueues.getOncology());
        orderByProhibited(specializationQueues.getOphthalmology());
        orderByProhibited(specializationQueues.getOrthopedic());
        orderByProhibited(specializationQueues.getPediatric());
        orderByProhibited(specializationQueues.getPsychiatry());
        orderByProhibited(specializationQueues.getRadiology());
        orderByProhibited(specializationQueues.getUrology());
        orderByProhibited(specializationQueues.getSurgery());
        return specializationQueues;
    }

    public List<Appointment> orderByProhibited(List<Appointment> appointments) {
        appointments.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));
        return appointments;
    }

    public List<Appointment> setPriority(List<Appointment> appointments) {
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

        return newQueue;
    }

    public List<Appointment> sortedQueue(List<Appointment> queue, RiskRank riskRank) {

        List<Appointment> sortedQueue = new ArrayList<>(queue.stream()
                .filter(appointment -> appointment.getRiskRank().equals(riskRank)).toList());
        sortedQueue.sort(Comparator.comparing(Appointment::getProhibited, Comparator.reverseOrder()));

        return sortedQueue;
    }

    public SpecializationQueues getQueues() {
        return queues;
    }
}
