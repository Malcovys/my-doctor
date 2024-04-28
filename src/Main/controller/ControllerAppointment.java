package main.controller;

import java.sql.SQLException;
import main.model.ModelAppointment;
import main.model.ModelPatient;
import main.services.ServiceAppointment;
import main.services.ServiceServices;
import main.services.ServiceUser;

/**
 *
 * @author malco
 */
public class ControllerAppointment {

    public ControllerAppointment() {
    }
    
    public void createAppointementWith(ModelPatient patient, String dorctor, String date, String hour, String reason) throws SQLException {
        ServiceUser serviceUser = new ServiceUser();
        int doctorId = serviceUser.getUserIDByName(dorctor);
        int receptionostID = serviceUser.getUserIDByName("receptioniste 1");
        
        ModelAppointment appointment = new ModelAppointment(patient.getPatient_id(), doctorId, receptionostID,date, hour);
        appointment.setEndHour(ControllerServices.calculateEndHour(appointment.getHour(), reason));
        
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        serviceAppointment.createAppoitment(appointment);
    }
    
    public String[] getFreeDoctor(String date, String hour) throws SQLException
    {
        ServiceUser serviceUser = new ServiceUser();
        ModelAppointment modelAppointment = new ModelAppointment();
        
        modelAppointment.setDate(date);
        modelAppointment.setHour(hour);
        
        return  serviceUser.getFreeDoctorAt(modelAppointment.getDate(), modelAppointment.getHour());
    }
}
