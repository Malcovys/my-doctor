package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.connection.DatabaseConnection;
import main.model.ModelAppointment;

/**
 *
 * @author malco
 */
public class ServiceAppointment {
    private final Connection conn;
    
    public ServiceAppointment() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void createAppoitment(ModelAppointment appointment) throws SQLException {
        PreparedStatement query = conn.prepareStatement(
                "INSERT INTO `appointment` (`date`, `hour`, `patientID`, `receptionistID`, `doctorID`) "
                        + "VALUES (?, ?, ?, ?, ?)");
        
        query.setString(1, appointment.getDate());
        query.setString(2, appointment.getHour());
        query.setInt(3, appointment.getPatient_id());
        query.setInt(4, appointment.getReceptionist_id());
        query.setInt(5, appointment.getDoctor_id());
        
        query.execute();
    }
}
