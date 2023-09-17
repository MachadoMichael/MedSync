package com.machado.MediSync.api.patient.controllers;

import com.machado.MediSync.api.patient.dtos.PatientDTO;
import com.machado.MediSync.api.patient.entities.Patient;
import com.machado.MediSync.api.patient.services.PatientService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getOne(@PathVariable(value = "id") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(cpf));
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientDTO patientDTO) {
        Patient patient = new Patient(
                patientDTO.name(),
                patientDTO.cpf(),
                patientDTO.address(),
                patientDTO.bloodType(),
                patientDTO.info(),
                patientDTO.allergies()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(patient));
    }

    @PutMapping
    public ResponseEntity<Patient> updateOne(@RequestBody PatientDTO patientDTO) {
        Patient selectedPatient = service.getOne(patientDTO.cpf());
        BeanUtils.copyProperties(patientDTO, selectedPatient);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(selectedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") String cpf) {
        Patient selectedPatient = service.getOne(cpf);
        if (selectedPatient != null) {
            service.delete(selectedPatient);
            return ResponseEntity.status(HttpStatus.OK).body("Patient deleted with success.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found.");
    }

}
