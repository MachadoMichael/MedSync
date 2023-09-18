package com.machado.MediSync.api.patient.services;

import com.machado.MediSync.api.patient.entities.Patient;

import java.util.List;

public interface PatientService {
    Patient save(Patient patient);
    Patient getOne(String cpf);
    List<Patient> getAll();
    void delete(Patient patient);
}
