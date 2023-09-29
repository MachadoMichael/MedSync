package com.machado.MedSync.HospitalManager.entities;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospitalAttendanceRooms {
    private List<AttendanceRoom> internalMedicineRoom;
    private List<AttendanceRoom> pediatricRoom;
    private List<AttendanceRoom> cardiologyRoom;
    private List<AttendanceRoom> dermatologyRoom;
    private List<AttendanceRoom> gastroenterologyRoom;
    private List<AttendanceRoom> surgeryRoom;
    private List<AttendanceRoom> neurologyRoom;
    private List<AttendanceRoom> orthopedicRoom;
    private List<AttendanceRoom> obstetricGynecologyRoom;
    private List<AttendanceRoom> oncologyRoom;
    private List<AttendanceRoom> radiologyRoom;
    private List<AttendanceRoom> anesthesiologyRoom;
    private List<AttendanceRoom> urologyRoom;
    private List<AttendanceRoom>  ophthalmology;
    private List<AttendanceRoom>  psychiatry;


    public HospitalAttendanceRooms(List<AttendanceRoom> internalMedicineRoom,
                                   List<AttendanceRoom> pediatricRoom,
                                   List<AttendanceRoom> cardiologyRoom,
                                   List<AttendanceRoom> dermatologyRoom,
                                   List<AttendanceRoom> gastroenterologyRoom,
                                   List<AttendanceRoom> surgeryRoom,
                                   List<AttendanceRoom> neurologyRoom,
                                   List<AttendanceRoom> orthopedicRoom,
                                   List<AttendanceRoom> obstetricGynecologyRoom,
                                   List<AttendanceRoom> oncologyRoom,
                                   List<AttendanceRoom> radiologyRoom,
                                   List<AttendanceRoom> anesthesiologyRoom,
                                   List<AttendanceRoom> urologyRoom, List<AttendanceRoom> ophthalmology, List<AttendanceRoom> psychiatry) {
        this.internalMedicineRoom = internalMedicineRoom;
        this.pediatricRoom = pediatricRoom;
        this.cardiologyRoom = cardiologyRoom;
        this.dermatologyRoom = dermatologyRoom;
        this.gastroenterologyRoom = gastroenterologyRoom;
        this.surgeryRoom = surgeryRoom;
        this.neurologyRoom = neurologyRoom;
        this.orthopedicRoom = orthopedicRoom;
        this.obstetricGynecologyRoom = obstetricGynecologyRoom;
        this.oncologyRoom = oncologyRoom;
        this.radiologyRoom = radiologyRoom;
        this.anesthesiologyRoom = anesthesiologyRoom;
        this.urologyRoom = urologyRoom;
        this.ophthalmology = ophthalmology;
        this.psychiatry = psychiatry;
    }



    public List<AttendanceRoom> getOphthalmology() {
        return ophthalmology;
    }

    public void setOphthalmology(List<AttendanceRoom> ophthalmology) {
        this.ophthalmology = ophthalmology;
    }

    public List<AttendanceRoom> getInternalMedicineRoom() {
        return internalMedicineRoom;
    }

    public void setInternalMedicineRoom(List<AttendanceRoom> internalMedicineRoom) {
        this.internalMedicineRoom = internalMedicineRoom;
    }

    public List<AttendanceRoom> getPediatricRoom() {
        return pediatricRoom;
    }

    public void setPediatricRoom(List<AttendanceRoom> pediatricRoom) {
        this.pediatricRoom = pediatricRoom;
    }

    public List<AttendanceRoom> getCardiologyRoom() {
        return cardiologyRoom;
    }

    public void setCardiologyRoom(List<AttendanceRoom> cardiologyRoom) {
        this.cardiologyRoom = cardiologyRoom;
    }

    public List<AttendanceRoom> getDermatologyRoom() {
        return dermatologyRoom;
    }

    public void setDermatologyRoom(List<AttendanceRoom> dermatologyRoom) {
        this.dermatologyRoom = dermatologyRoom;
    }

    public List<AttendanceRoom> getGastroenterologyRoom() {
        return gastroenterologyRoom;
    }

    public void setGastroenterologyRoom(List<AttendanceRoom> gastroenterologyRoom) {
        this.gastroenterologyRoom = gastroenterologyRoom;
    }

    public List<AttendanceRoom> getSurgeryRoom() {
        return surgeryRoom;
    }

    public void setSurgeryRoom(List<AttendanceRoom> surgeryRoom) {
        this.surgeryRoom = surgeryRoom;
    }

    public List<AttendanceRoom> getNeurologyRoom() {
        return neurologyRoom;
    }

    public void setNeurologyRoom(List<AttendanceRoom> neurologyRoom) {
        this.neurologyRoom = neurologyRoom;
    }

    public List<AttendanceRoom> getOrthopedicRoom() {
        return orthopedicRoom;
    }

    public void setOrthopedicRoom(List<AttendanceRoom> orthopedicRoom) {
        this.orthopedicRoom = orthopedicRoom;
    }

    public List<AttendanceRoom> getObstetricGynecologyRoom() {
        return obstetricGynecologyRoom;
    }

    public void setObstetricGynecologyRoom(List<AttendanceRoom> obstetricGynecologyRoom) {
        this.obstetricGynecologyRoom = obstetricGynecologyRoom;
    }

    public List<AttendanceRoom> getOncologyRoom() {
        return oncologyRoom;
    }

    public void setOncologyRoom(List<AttendanceRoom> oncologyRoom) {
        this.oncologyRoom = oncologyRoom;
    }

    public List<AttendanceRoom> getRadiologyRoom() {
        return radiologyRoom;
    }

    public void setRadiologyRoom(List<AttendanceRoom> radiologyRoom) {
        this.radiologyRoom = radiologyRoom;
    }

    public List<AttendanceRoom> getAnesthesiologyRoom() {
        return anesthesiologyRoom;
    }

    public void setAnesthesiologyRoom(List<AttendanceRoom> anesthesiologyRoom) {
        this.anesthesiologyRoom = anesthesiologyRoom;
    }

    public List<AttendanceRoom> getUrologyRoom() {
        return urologyRoom;
    }

    public void setUrologyRoom(List<AttendanceRoom> urologyRoom) {
        this.urologyRoom = urologyRoom;
    }

    public List<AttendanceRoom> getPsychiatry() {
        return psychiatry;
    }

    public void setPsychiatry(List<AttendanceRoom> psychiatry) {
        this.psychiatry = psychiatry;
    }
}
