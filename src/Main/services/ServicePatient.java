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
    
    public ModelPatient getPatientByTelephone(String telephone) throws SQLException {
        ModelPatient patient = null;
        PreparedStatement query = null;
        ResultSet res = null;

        try {
            query = conn.prepareStatement("select * from `patient` where `telephone` = ?");
            query.setString(1, telephone);
            res = query.executeQuery();

            if (res.next()) {
                int id = res.getInt("patientID");
                String firstName = res.getString("firstName");
                String lastName = res.getString("lastName");
                String email = res.getString("email");

                patient = new ModelPatient();
                patient.setPatient_id(id);
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                patient.setEmail(email);
                patient.setTelephone(telephone);
            }
        } finally {
            if (res != null) {
                res.close();
            }
            if (query != null) {
                query.close();
            }
        }

        return patient;
    }

    
    public void insertPatient(ModelPatient patient) throws SQLException {
        PreparedStatement query = conn.prepareStatement(
                "INSERT INTO `patient` (`firstName`, `lastName`, `email`, `telephone`) "
                        + "VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        
        query.setString(1, patient.getFirstName());
        query.setString(2, patient.getLastName());
        query.setString(3, patient.getEmail());
        query.setString(4, patient.getTelephone());
        
        query.execute();
        
        ResultSet res = query.getGeneratedKeys();
        res.first();
        int patientID = res.getInt(1);
        res.close();
        res.close();
        patient.setPatient_id(patientID);
    }
}
