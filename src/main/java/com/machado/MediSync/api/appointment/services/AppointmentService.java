package com.machado.MediSync.api.appointment.services;

import com.machado.MediSync.api.appointment.entities.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment save(Appointment appointment);
    Appointment getOne(String cpf);
    List<Appointment> getAll();
    void delete(Appointment appointment);
}
