package com.machado.MedSync.api.doctor.dtos;

import com.machado.MedSync.api.doctor.enums.Specialization;

public record DoctorDTO(
        String name,
        String cpf,
        String address,
        Specialization specialization
) {
}
