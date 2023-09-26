package com.machado.MedSync.api.patient.repositories;

import com.machado.MedSync.api.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    Patient getByCpf(String cpf);
}
