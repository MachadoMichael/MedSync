package com.machado.MedSync.api.appointment.entities;

import com.machado.MedSync.api.doctor.enums.Specialization;
import com.machado.MedSync.api.patient.enums.RiskRank;
import com.machado.MedSync.api.patient.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
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
    Specialization requiredSpecialization;

    public Specialization getRequiredSpecialization() {
        return requiredSpecialization;
    }

    public void setRequiredSpecialization(Specialization requiredSpecialization) {
        this.requiredSpecialization = requiredSpecialization;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getResponsibleDoctor() {
        return responsibleDoctor;
    }

    public void setResponsibleDoctor(Integer responsibleDoctor) {
        this.responsibleDoctor = responsibleDoctor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getProhibited() {
        return prohibited;
    }

    public void setProhibited(LocalDateTime prohibited) {
        this.prohibited = prohibited;
    }

    public LocalDateTime getExit() {
        return exit;
    }

    public void setExit(LocalDateTime exit) {
        this.exit = exit;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public RiskRank getRiskRank() {
        return riskRank;
    }

    public void setRiskRank(RiskRank riskRank) {
        this.riskRank = riskRank;
    }
}
