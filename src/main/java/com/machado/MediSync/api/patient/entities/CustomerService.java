package com.machado.MediSync.api.patient.entities;

import com.machado.MediSync.api.patient.enums.RiskRank;
import com.machado.MediSync.api.patient.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CUSTOMER_SERVICE")
public class CustomerService implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String patientId;
    Status status;
    LocalDate prohibited;
    LocalDate exit;
    Double bloodPressure;
    String info;
    RiskRank riskRank;
}
