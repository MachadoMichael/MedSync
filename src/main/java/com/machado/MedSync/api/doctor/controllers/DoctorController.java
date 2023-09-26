package com.machado.MedSync.api.doctor.controllers;

import com.machado.MedSync.api.doctor.dtos.DoctorDTO;
import com.machado.MedSync.api.doctor.entities.Doctor;
import com.machado.MedSync.api.doctor.services.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService service;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getOne(@PathVariable(value = "id") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(cpf));
    }

    @PostMapping
    public ResponseEntity<Doctor> save(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(
                doctorDTO.name(),
                doctorDTO.cpf(),
                doctorDTO.address(),
                doctorDTO.specialization()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(doctor));
    }

    @PutMapping
    public ResponseEntity<Doctor> updateOne(@RequestBody DoctorDTO doctorDTO) {
        Doctor selectedDoctor = service.getOne(doctorDTO.cpf());
        BeanUtils.copyProperties(doctorDTO, selectedDoctor);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(selectedDoctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") String cpf) {
        Doctor selectedDoctor = service.getOne(cpf);
        if (selectedDoctor != null) {
            service.delete(selectedDoctor);
            return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted with success.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor not found.");
    }

}
