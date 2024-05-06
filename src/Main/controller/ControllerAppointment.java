package main.controller;

import java.sql.SQLException;
import main.model.ModelAppointment;
import main.model.ModelPatient;
import main.services.ServiceAppointment;

/**
 *
 * @author malco
 */
public class ControllerAppointment {
    
    public static void createAppointementWith(ModelPatient patient, String dorctor, String date, String hour, String reason) throws SQLException {
        int doctorId = ControllerUser.getIdByName(dorctor);
        int receptionostID = ControllerUser.getIdByName("receptioniste 1");
        
        ModelAppointment appointment = new ModelAppointment(patient.getPatient_id(), doctorId, receptionostID,date, hour);
        appointment.setService_id(ControllerServices.getIdOf(reason));
        appointment.setEndHour(ControllerServices.calculateEndHour(appointment.getHour(), reason));
        
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        serviceAppointment.createAppoitment(appointment);
    }
}
