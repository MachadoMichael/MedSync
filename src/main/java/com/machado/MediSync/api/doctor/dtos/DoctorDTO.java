package com.machado.MediSync.api.doctor.dtos;

import com.machado.MediSync.api.doctor.enums.Specialization;

public record DoctorDTO(
        String name,
        String cpf,
        String address,
        Specialization specialization
) {
}
