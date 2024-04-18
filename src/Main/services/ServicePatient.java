package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.connection.DatabaseConnection;
import main.model.ModelPatient;

/**
 *
 * @author malco
 */
public class ServicePatient {
    private final Connection conn;
    
    public ServicePatient() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void insertPatient(ModelPatient patient) throws SQLException {
        PreparedStatement query = conn.prepareStatement(
                "INSERT INTO `patient` (`firstName`, `lastName`, `bithDate`, `email`, `telephone`) "
                        + "VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        
        query.setString(1, patient.getFirstName());
        query.setString(2, patient.getLastName());
        query.setString(3, patient.getBirthDate());
        query.setString(4, patient.getEmail());
        query.setString(5, patient.getTelephone());
        
        query.execute();
        
        ResultSet res = query.getGeneratedKeys();
        res.first();
        int patientID = res.getInt(1);
        res.close();
        res.close();
        patient.setPatient_id(patientID);
    }
}
