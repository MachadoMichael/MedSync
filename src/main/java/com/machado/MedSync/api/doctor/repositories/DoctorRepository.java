package com.machado.MedSync.api.doctor.repositories;

import com.machado.MedSync.api.doctor.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    Doctor getByCpf(String cpf);
}
