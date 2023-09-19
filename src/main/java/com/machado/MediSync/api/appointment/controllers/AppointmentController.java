package com.machado.MediSync.api.appointment.controllers;

import com.machado.MediSync.api.appointment.dtos.AppointmentDTO;
import com.machado.MediSync.api.appointment.entities.Appointment;
import com.machado.MediSync.api.appointment.services.AppointmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment(

        );

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(appointment));
    }

    @PutMapping
    public ResponseEntity<Appointment> updateOne(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment selectedAppointment = service.getOne(appointmentDTO.cpf());
        BeanUtils.copyProperties(appointmentDTO, selectedAppointment);
        return ResponseEntity.status(HttpStatus.OK).body(service.save(selectedAppointment));
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
