package com.machado.MedSync.api.appointment.repositories;

import com.machado.MedSync.api.appointment.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findByPatientId(Integer patientId);
    List<Appointment> findByResponsibleDoctor(Integer responsibleDoctor);
}
