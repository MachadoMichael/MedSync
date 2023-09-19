package com.machado.MediSync.api.appointment.entities;

import com.machado.MediSync.api.patient.enums.RiskRank;
import com.machado.MediSync.api.patient.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    Integer patientId;
    Integer responsibleDoctor;
    Status status;
    LocalDateTime prohibited;
    LocalDateTime exit;
    Double bloodPressure;
    String info;
    RiskRank riskRank;
}
