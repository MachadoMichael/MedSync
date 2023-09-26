package com.machado.MedSync.api.doctor.services;

import com.machado.MedSync.api.doctor.entities.Doctor;
import com.machado.MedSync.api.doctor.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorServiceImp implements DoctorService{

    @Autowired
    DoctorRepository repository;

    @Override
    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor getOne(String cpf) {
        return repository.getByCpf(cpf);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Doctor doctor) {
        repository.delete(doctor);
    }

}
