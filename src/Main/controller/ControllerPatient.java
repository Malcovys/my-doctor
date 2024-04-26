package main.controller;

import java.sql.SQLException;
import main.model.ModelPatient;
import main.services.ServicePatient;

/**
 *
 * @author malco
 */
public class ControllerPatient {

    public ControllerPatient() {}
    
    public boolean getPatientsByTelephone(ModelPatient patient) throws SQLException {
        ServicePatient servicePatient = new ServicePatient();
        ModelPatient patient_in = servicePatient.getPatientByTelephone(patient.getTelephone());
        
        if(patient_in.getPatient_id() != -1){
            patient.setPatient_id(patient_in.getPatient_id());
            patient.setFirstName(patient_in.getFirstName());
            patient.setLastName(patient_in.getLastName());
            patient.setEmail(patient_in.getEmail());
            
            return true;
        }
        
        return false;
    }
    
    public void savePatient(ModelPatient patient) throws SQLException {
        ServicePatient servicePatient = new ServicePatient();
        servicePatient.insertPatient(patient);
    }
}
