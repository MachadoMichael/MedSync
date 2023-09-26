package com.machado.MedSync.HospitalManager;

import com.machado.MedSync.api.doctor.entities.Doctor;

import java.util.List;

public class AttendanceRoom {
    private Doctor resposibleDoctor;
    private RoomStatus roomStatus;

    public AttendanceRoom(Doctor resposibleDoctor, RoomStatus roomStatus) {
        this.resposibleDoctor = resposibleDoctor;
        this.roomStatus = roomStatus;
    }

    public Doctor getResposibleDoctor() {
        return resposibleDoctor;
    }

    public void setResposibleDoctor(Doctor resposibleDoctor) {
        this.resposibleDoctor = resposibleDoctor;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
