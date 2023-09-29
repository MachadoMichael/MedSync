package com.machado.MedSync.HospitalManager;

import com.machado.MedSync.api.appointment.entities.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueuesManager {
    private List<Appointment> internalMedicine;
    private List<Appointment> pediatric;
    private List<Appointment> cardiology;
    private List<Appointment> dermatology;
    private List<Appointment> gastroenterology;
    private List<Appointment> surgery;
    private List<Appointment> neurology;
    private List<Appointment> orthopedic;
    private List<Appointment> obstetricGynecology;
    private List<Appointment> oncology;
    private List<Appointment> radiology;
    private List<Appointment> anesthesiology;
    private List<Appointment> urology;
    private List<Appointment>  ophthalmology;
    private List<Appointment>  psychiatry;
    private List<List<Appointment>>  queueManagerLists;
    

    public List<List<Appointment>> getHospitalAttendanceLists(){
        queueManagerLists.add(internalMedicine);
        queueManagerLists.add(pediatric);
        queueManagerLists.add(cardiology);
        queueManagerLists.add(dermatology);
        queueManagerLists.add(gastroenterology);
        queueManagerLists.add(surgery);
        queueManagerLists.add(neurology);
        queueManagerLists.add(orthopedic);
        queueManagerLists.add(obstetricGynecology);
        queueManagerLists.add(oncology);
        queueManagerLists.add(radiology);
        queueManagerLists.add(anesthesiology);
        queueManagerLists.add(urology);
        queueManagerLists.add(ophthalmology);
        queueManagerLists.add(psychiatry);

        return queueManagerLists;
    }
    public List<Appointment> getInternalMedicine() {
        return internalMedicine;
    }

    public void setInternalMedicine(Appointment internalMedicine) {
        this.internalMedicine.add(internalMedicine);
    }

    public List<Appointment> getPediatric() {
        return pediatric;
    }

    public void setPediatric(Appointment pediatric) {
        this.pediatric.add(pediatric);
    }

    public List<Appointment> getCardiology() {
        return cardiology;
    }

    public void setCardiology(Appointment cardiology) {
        this.cardiology.add(cardiology);
    }

    public List<Appointment> getDermatology() {
        return dermatology;
    }

    public void setDermatology(Appointment dermatology) {
        this.dermatology.add(dermatology);
    }

    public List<Appointment> getGastroenterology() {
        return gastroenterology;
    }

    public void setGastroenterology(Appointment gastroenterology) {
        this.gastroenterology.add(gastroenterology);
    }

    public List<Appointment> getSurgery() {
        return surgery;
    }

    public void setSurgery(Appointment surgery) {
        this.surgery.add(surgery);
    }

    public List<Appointment> getNeurology() {
        return neurology;
    }

    public void setNeurology(Appointment neurology) {
        this.neurology.add(neurology);
    }

    public List<Appointment> getOrthopedic() {
        return orthopedic;
    }

    public void setOrthopedic(Appointment orthopedic) {
        this.orthopedic.add(orthopedic);
    }

    public List<Appointment> getObstetricGynecology() {
        return obstetricGynecology;
    }

    public void setObstetricGynecology(Appointment obstetricGynecology) {
        this.obstetricGynecology.add(obstetricGynecology);
    }

    public List<Appointment> getOncology() {
        return oncology;
    }

    public void setOncology(Appointment oncology) {
        this.oncology.add(oncology);
    }

    public List<Appointment> getRadiology() {
        return radiology;
    }

    public void setRadiology(Appointment radiology) {
        this.radiology.add(radiology);
    }

    public List<Appointment> getAnesthesiology() {
        return anesthesiology;
    }

    public void setAnesthesiology(Appointment anesthesiology) {
        this.anesthesiology.add(anesthesiology);
    }

    public List<Appointment> getUrology() {
        return urology;
    }

    public void setUrology(Appointment urology) {
        this.urology.add(urology);
    }

    public List<Appointment> getOphthalmology() {
        return ophthalmology;
    }

    public void setOphthalmology(Appointment ophthalmology) {
        this.ophthalmology.add(ophthalmology);
    }
    public List<Appointment> getPsychiatry() {
        return psychiatry;
    }

    public void setPsychiatry(Appointment psychiatry) {
        this.psychiatry.add(psychiatry);
    }
}
