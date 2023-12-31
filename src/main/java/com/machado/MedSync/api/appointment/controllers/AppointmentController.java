package com.machado.MedSync.api.appointment.controllers;

import com.machado.MedSync.api.appointment.dtos.AppointmentDTO;
import com.machado.MedSync.api.appointment.entities.Appointment;
import com.machado.MedSync.api.appointment.services.AppointmentService;
import com.machado.MedSync.api.patient.enums.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    @GetMapping
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getOne(@PathVariable(value = "id") String cpf) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getOne(cpf));
    }

    @GetMapping("/queue/riskClassification")
    public ResponseEntity<List<Appointment>> getQueueRiskClassification() {
        List<Appointment> queueRiskClassification = service.getAll().stream()
                .filter(appointment -> appointment.getStatus().equals(Status.RISK_CLASSIFICATION)).toList();
        queueRiskClassification.sort(Comparator.comparing(Appointment::getProhibited));

        return ResponseEntity.status(HttpStatus.OK).body(queueRiskClassification);
    }

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        BeanUtils.copyProperties(appointmentDTO, appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable(value = "id") String cpf) {
        Appointment selectedAppointment = service.getOne(cpf);
        if (selectedAppointment != null) {
            service.delete(selectedAppointment);
            return ResponseEntity.status(HttpStatus.OK).body("Appointment deleted with success.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found.");
    }

}
