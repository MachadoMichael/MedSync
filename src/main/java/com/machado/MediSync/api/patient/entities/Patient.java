package com.machado.MediSync.api.patient.entities;

import com.machado.MediSync.api.Person;
import com.machado.MediSync.api.patient.enums.BloodType;
import com.machado.MediSync.api.patient.enums.Status;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PATIENTS")
public class Patient extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    BloodType bloodType;
    String info;
    String allergies;
    List<UUID> history;

    public Patient(String name, String cpf, String address, BloodType bloodType, String info, String allergies) {
        super(name, cpf, address);
        this.bloodType = bloodType;
        this.info = info;
        this.allergies = allergies;
        this.history = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public List<UUID> getHistory() {
        return history;
    }

    public void setHistory(List<UUID> history) {
        this.history = history;
    }
}
