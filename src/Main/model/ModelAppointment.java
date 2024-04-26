package main.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author malco
 */
public class ModelAppointment {
    private int appointementID;
    private int patient_id;
    private int doctor_id;
    private int receptionist_id;
    private LocalDate date;
    private LocalTime hour;
    
    DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    

    public ModelAppointment(int patient_id, int doctor_id, int receptionist_id, String date, String hour) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.receptionist_id = receptionist_id;
        this.date = LocalDate.parse(date, dateFormat);
        this.hour = LocalTime.parse(hour, timeFormat);
    }

    public ModelAppointment() {
        this.patient_id = -1;
        this.doctor_id = -1;
        this.receptionist_id = -1;
        this.date = null;
        this.hour = null;
    }  
    
    public int getAppointementID() {
        return appointementID;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public int getReceptionist_id() {
        return receptionist_id;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public LocalTime getHour() {
        return hour;
    }

    public void setAppointementID(int appointementID) {
        this.appointementID = appointementID;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setReceptionist_id(int receptionist_id) {
        this.receptionist_id = receptionist_id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setDate(String date) {
        this.date = LocalDate.parse(date, dateFormat);
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }
    
    public void setHour(String hour) {
        this.hour = LocalTime.parse(hour, timeFormat);
    }
}
