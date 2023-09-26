package com.machado.MedSync.api.patient.dtos;

import com.machado.MedSync.api.patient.enums.BloodType;

public record PatientDTO(
        String name,
        String cpf,
        String address,
        BloodType bloodType,
        String info,
        String allergies
) {
}
