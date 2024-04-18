package main.controller;

import java.sql.SQLException;
import main.model.ModelAppointment;
import main.model.ModelPatient;
import main.services.ServiceAppointment;
import main.services.ServicePatient;
import main.services.ServiceUser;

/**
 *
 * @author malco
 */
public class ContellerAppointment {

    public ContellerAppointment() {
    }
    
    public void createAppointementWith(ModelPatient patient, String dorctor, String date, String hour) throws SQLException {
        ServiceUser serviceUser = new ServiceUser();
        int doctorId = serviceUser.getUserIDByName(dorctor);
        int receptionostID = serviceUser.getUserIDByName("receptioniste 1");
        
        ServicePatient servicePatient = new ServicePatient();
        servicePatient.insertPatient(patient);
        
        ModelAppointment appointment = new ModelAppointment(patient.getPatient_id(), doctorId, receptionostID,date, hour);
        
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        serviceAppointment.createAppoitment(appointment);
    }
}
