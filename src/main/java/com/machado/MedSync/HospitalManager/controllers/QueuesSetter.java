package com.machado.MedSync.HospitalManager.controllers;


import com.machado.MedSync.HospitalManager.entities.SpecializationQueues;
import com.machado.MedSync.api.appointment.entities.Appointment;
import com.machado.MedSync.api.appointment.services.AppointmentService;
import com.machado.MedSync.api.patient.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueuesSetter {

    @Autowired
    AppointmentService appointmentService;

    private SpecializationQueues waitingForService;


    @Scheduled(fixedRate = 5000)
    public void checkQueue() {
        List<Appointment> appointments = appointmentService.getAll().stream()
                .filter(appointment -> !appointment.getStatus().equals(Status.FINISHED)).toList();

        if (!appointments.isEmpty()) {

            List<Appointment> queueRisk = appointments.stream()
                    .filter(appointment -> appointment.getStatus().equals(Status.RISK_CLASSIFICATION)).toList();

            List<Appointment> queueService = appointments.stream()
                    .filter(appointment -> appointment.getStatus().equals(Status.WAITING_FOR_SERVICE)).toList();

            waitingForService = setQueueResponsible(queueService);

        }
    }


    private SpecializationQueues setQueueResponsible(List<Appointment> appointments) {
        SpecializationQueues queuesManager = new SpecializationQueues();

        for (Appointment appointment : appointments) {

            switch (appointment.getRequiredSpecialization()) {
                case SURGERY -> queuesManager.setSurgery(appointment);
                case ANESTHESIOLOGY -> queuesManager.setAnesthesiology(appointment);
                case CARDIOLOGY -> queuesManager.setCardiology(appointment);
                case DERMATOLOGY -> queuesManager.setDermatology(appointment);
                case GASTROENTEROLOGY -> queuesManager.setGastroenterology(appointment);
                case INTERNAL_MEDICINE -> queuesManager.setInternalMedicine(appointment);
                case NEUROLOGY -> queuesManager.setNeurology(appointment);
                case OBSTETRICS_GYNECOLOGY -> queuesManager.setObstetricGynecology(appointment);
                case ONCOLOGY -> queuesManager.setOncology(appointment);
                case OPHTHALMOLOGY -> queuesManager.setOphthalmology(appointment);
                case ORTHOPEDICS -> queuesManager.setOrthopedic(appointment);
                case PEDIATRICS -> queuesManager.setPediatric(appointment);
                case PSYCHIATRY -> queuesManager.setPsychiatry(appointment);
                case RADIOLOGY -> queuesManager.setRadiology(appointment);
                case UROLOGY -> queuesManager.setUrology(appointment);
            }
        }

        return queuesManager;
    }






}