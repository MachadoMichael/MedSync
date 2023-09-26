package com.machado.MedSync.api.doctor.services;

import com.machado.MedSync.api.doctor.entities.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor getOne(String cpf);
    List<Doctor> getAll();
    void delete(Doctor doctor);
}
