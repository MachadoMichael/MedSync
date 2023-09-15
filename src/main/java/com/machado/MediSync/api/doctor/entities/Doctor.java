package com.machado.MediSync.api.doctor.entities;

import com.machado.MediSync.api.Person;
import com.machado.MediSync.api.doctor.enums.ServiceStatus;
import com.machado.MediSync.api.doctor.enums.Specialization;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "DOCTORS")
public class Doctor extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Specialization specialization;
    ServiceStatus serviceStatus;
}
