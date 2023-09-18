package com.machado.MediSync.api.doctor.entities;

import com.machado.MediSync.api.Person;
import com.machado.MediSync.api.doctor.enums.ServiceStatus;
import com.machado.MediSync.api.doctor.enums.Specialization;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "DOCTORS")
public class Doctor extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Specialization specialization;
    ServiceStatus serviceStatus;

    public Doctor(String name, String cpf, String address, Specialization specialization) {
        super(name, cpf, address);
        this.specialization = specialization;
        this.serviceStatus = ServiceStatus.OFF_DUTY;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
