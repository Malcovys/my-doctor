package main.controller;

import java.sql.SQLException;
import java.util.Dictionary;
import main.model.ModelAppointment;
import main.model.ModelPatient;
import main.model.ModelStatus;
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
    
    public static Dictionary getAppoitementInfos(int appoitementID) throws SQLException {
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        return serviceAppointment.getAppoitementInfos(appoitementID);
    }
    
    public static Dictionary[] getAppoitementListOfStatus(ModelStatus modelStatus) throws SQLException {
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        return  serviceAppointment.getAppoitementsByStatus(modelStatus);
    }
    
    public static void setSatusComplete(int appoitementID) throws SQLException {
        ModelStatus modelStatus = new ModelStatus();
        modelStatus.setComplete();
        
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        serviceAppointment.updateStatusID(appoitementID, modelStatus);
    }
    
    public static void setSatusDesable(int appoitementID) throws SQLException {
         ModelStatus modelStatus = new ModelStatus();
        modelStatus.setDesabled();
        
        ServiceAppointment serviceAppointment = new ServiceAppointment();
        serviceAppointment.updateStatusID(appoitementID, modelStatus);
    }
}
