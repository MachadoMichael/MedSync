package com.machado.MedSync.api.doctor.entities;

import com.machado.MedSync.api.Person;
import com.machado.MedSync.api.doctor.enums.ServiceStatus;
import com.machado.MedSync.api.doctor.enums.Specialization;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "DOCTORS")
public class Doctor extends Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Specialization specialization;
    ServiceStatus serviceStatus;

    public Doctor(String name, String cpf, String address, Specialization specialization) {
        super(name, cpf, address);
        this.specialization = specialization;
        this.serviceStatus = ServiceStatus.OFF_DUTY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
