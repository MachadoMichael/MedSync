package com.machado.MediSync.api.patient.services;

import com.machado.MediSync.api.patient.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImp implements PatientService {

    @Autowired
    PatientService service;

    @Override
    public Patient save(Patient patient) {
        return service.save(patient);
    }

    @Override
    public Patient getOne(String cpf) {
        return service.getOne(cpf);
    }

    @Override
    public List<Patient> getAll() {
        return service.getAll();
    }

    @Override
    public void delete(Patient patient) {
        service.delete(patient);
    }
}
