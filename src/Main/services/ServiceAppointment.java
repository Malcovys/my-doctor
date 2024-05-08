package main.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.connection.DatabaseConnection;
import main.model.ModelAppointment;
import main.model.ModelStatus;

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
                "INSERT INTO `appointment` (`date`, `hour`, `endHour`, `patientID`, `receptionistID`, `doctorID`, `serviceID`) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)");
        
        query.setDate(1, Date.valueOf(appointment.getDate()));
        query.setTime(2, Time.valueOf(appointment.getHour()));
        query.setTime(3, Time.valueOf(appointment.getEndHour()));
        query.setInt(4, appointment.getPatient_id());
        query.setInt(5, appointment.getReceptionist_id());
        query.setInt(6, appointment.getDoctor_id());
        query.setInt(7, appointment.getService_id());
        
        query.execute();
    }
    
    public Dictionary[] getAppoitementsByStatus(ModelStatus modelStatus) throws SQLException {
        List<Dictionary> appoitementsList = new ArrayList<>();
  
        String sql = """
                SELECT
                    appointment.appointmentID AS id,
                    appointment.date,
                    appointment.hour,
                    user.userName AS doctor,
                    service.title AS reason,
                    patient.firstName AS patientFirstName,
                    patient.lastName AS patientLastName,
                    appoitementstatus.status
                FROM
                    appointment
                JOIN
                    patient ON appointment.patientID = patient.patientID
                JOIN
                    user ON appointment.doctorID = user.userID
                JOIN
                    service ON appointment.serviceID = service.serviceID
                JOIN
                    appoitementstatus ON appointment.appoitement_statusID = appoitementstatus.appoitement_statusID
                WHERE
                    appointment.appoitement_statusID = (
                            SELECT appoitementstatus.appoitement_statusID
                            FROM appoitementstatus
                            WHERE appoitementstatus.status = ?
                    )
                ORDER BY
                    appointment.appointmentID DESC
            """;
        
        PreparedStatement query = conn.prepareStatement(sql);
        query.setString(1, modelStatus.getStatus());
        
        ResultSet res = query.executeQuery();
        
        while (res.next()) {
            Dictionary<String, String> appoitementInfos = new Hashtable<>();
            
            appoitementInfos.put("id", res.getString("id"));
            appoitementInfos.put("date", res.getDate("date").toString());
            appoitementInfos.put("hour", res.getTime("hour").toString());
            appoitementInfos.put("doctor", res.getString("doctor"));
            appoitementInfos.put("patientFirstName", res.getString("patientFirstName"));
            appoitementInfos.put("patientLastName", res.getString("patientLastName"));
            appoitementInfos.put("reason", res.getString("reason"));
            appoitementInfos.put("status", res.getString("status"));
            
            appoitementsList.add(appoitementInfos);
        }
        
        return appoitementsList.toArray(Dictionary[]::new);
    }
    
    public void updateStatusID(int appoitementID, ModelStatus modelStatus) throws SQLException{
        try {
            String sql = """
                            UPDATE appointment
                            SET appointment.appoitement_statusID = (
                                SELECT appoitementstatus.appoitement_statusID
                                FROM appoitementstatus
                                WHERE appoitementstatus.status = ?
                            ) WHERE appointment.appointmentID = ?;
                        """;
            
            PreparedStatement query = conn.prepareStatement(sql);
            query.setString(1, modelStatus.getStatus());
            query.setInt(2, appoitementID);
            query.execute();
        } catch (Exception ex) {
            Logger.getLogger(ServiceAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
