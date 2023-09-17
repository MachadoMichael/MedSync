package com.machado.MediSync.api.patient.dtos;

import com.machado.MediSync.api.patient.enums.BloodType;

public record PatientDTO(
        String name,
        String cpf,
        String address,
        BloodType bloodType,
        String info,
        String allergies
) {
}
