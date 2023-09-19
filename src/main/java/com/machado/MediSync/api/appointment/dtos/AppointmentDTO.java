package com.machado.MediSync.api.appointment.dtos;

import com.machado.MediSync.api.patient.enums.RiskRank;
import com.machado.MediSync.api.patient.enums.Status;

import java.time.LocalDateTime;

public record AppointmentDTO(
        Integer patientId,
        Integer responsibleDoctor,
        Status status,
        LocalDateTime prohibited,
        LocalDateTime exit,
        Double bloodPressure,
        String info,
        RiskRank riskrank
) {
}
