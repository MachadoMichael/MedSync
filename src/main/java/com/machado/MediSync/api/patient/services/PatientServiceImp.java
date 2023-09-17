package com.machado.MediSync.api.patient.services;

import com.machado.MediSync.api.patient.dtos.PatientDTO;
import com.machado.MediSync.api.patient.entities.Patient;
import com.machado.MediSync.api.patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientServiceImp implements PatientService{

    @Autowired
    PatientRepository repository;

    @Override
    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient getOne(String cpf) {
       return repository.getByCpf(cpf);
    }

    @Override
    public List<Patient> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Patient patient) {
       repository.delete(patient);
    }

}
