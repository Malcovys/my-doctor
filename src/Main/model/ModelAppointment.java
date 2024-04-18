package main.model;

/**
 *
 * @author malco
 */
public class ModelAppointment {
    private int appointementID;
    private int patient_id;
    private int doctor_id;
    private int receptionist_id;
    private String date;
    private String hour;

    public ModelAppointment(int patient_id, int doctor_id, int receptionist_id, String date, String hour) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.receptionist_id = receptionist_id;
        this.date = date;
        this.hour = hour;
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

    public String getDate() {
        return date;
    }
    
    public String getHour() {
        return hour;
    }
}
