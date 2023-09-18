package com.machado.MediSync.api.doctor.services;

import com.machado.MediSync.api.doctor.entities.Doctor;
import com.machado.MediSync.api.patient.entities.Patient;

import java.util.List;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor getOne(String cpf);
    List<Doctor> getAll();
    void delete(Doctor doctor);
}
