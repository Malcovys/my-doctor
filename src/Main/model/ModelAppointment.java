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
    private int service_id;
    private LocalDate date;
    private LocalTime hour;
    private LocalTime endHour;
    
    DateTimeFormatter dateFormat =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
    

    public ModelAppointment(int patient_id, int doctor_id, String date, String hour) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.service_id = -1;
        this.date = LocalDate.parse(date, dateFormat);
        this.hour = LocalTime.parse(hour, timeFormat);
        this.endHour = null;
    }

    public ModelAppointment() {
        this.patient_id = -1;
        this.doctor_id = -1;
        this.doctor_id = -1;
        this.date = null;
        this.hour = null;
        this.endHour = null;
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
    
    public int getService_id() {
        return service_id;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public LocalTime getHour() {
        return hour;
    }
    
    public LocalTime getEndHour() {
        return endHour;
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
    
    public void setService_id(int service_id) {
        this.service_id = service_id;
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
    
    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }
    
    public void setEndHour(String endHour) {
        this.endHour = LocalTime.parse(endHour, timeFormat);
    }
}
