package com.machado.MedSync.HospitalManager.entities;

import com.machado.MedSync.HospitalManager.enums.RoomStatus;
import com.machado.MedSync.api.doctor.entities.Doctor;

public class AttendanceRoom {
    private Doctor responsibleDoctor;
    private RoomStatus roomStatus;

    public AttendanceRoom(Doctor responsibleDoctor, RoomStatus roomStatus) {
        this.responsibleDoctor = responsibleDoctor;
        this.roomStatus = roomStatus;
    }

    public Doctor getResponsibleDoctor() {
        return responsibleDoctor;
    }

    public void setResponsibleDoctor(Doctor responsibleDoctor) {
        this.responsibleDoctor = responsibleDoctor;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
