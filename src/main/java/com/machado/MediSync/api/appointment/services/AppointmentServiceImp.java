package com.machado.MediSync.api.appointment.services;

import com.machado.MediSync.api.appointment.entities.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentServiceImp implements AppointmentService{
    @Autowired
    AppointmentService service;

    @Override
    public Appointment save(Appointment appointment) {
        return service.save(appointment);
    }

    @Override
    public Appointment getOne(String cpf) {
        return service.getOne(cpf);
    }

    @Override
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @Override
    public void delete(Appointment appointment) {
        service.delete(appointment);
    }
}
