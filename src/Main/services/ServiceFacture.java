package main.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import main.connection.DatabaseConnection;
import main.model.ModelFactureStatus;

/**
 *
 * @author malco
 */
public class ServiceFacture {
    
    private final Connection conn;
    
    public ServiceFacture() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void insertFacture(int appoitementID) throws SQLException {
        PreparedStatement query = conn.prepareStatement("INSERT INTO `facture` (`appoitmentID`) VALUES (?)");
        query.setInt(1, appoitementID);
        query.execute();
    }
    
    public void updateIsPaidColone(int factureID, boolean isPaid) throws SQLException {
        PreparedStatement query = conn.prepareStatement("UPDATE `facture` SET `isPaid` = ? WHERE `factureID` = ?");
        query.setBoolean(1, isPaid);
        query.setInt(2, factureID);
        query.execute();
    }
    
    public int getFactureIDByAppoitementID(int appoitementID) throws SQLException {
        int id = -1;
        PreparedStatement query = conn.prepareStatement("SELECT `factureID` FROM `facture` WHERE `appoitmentID` = ?");
        query.setInt(1, appoitementID);
        ResultSet res = query.executeQuery();
        if(res.next()) {
            id = res.getInt("factureID");
        }
        return  id;
    }
    
    public Dictionary[] getFacturesByPaidStatus(ModelFactureStatus modelStatus) throws SQLException {
        List<Dictionary> listFacture = new ArrayList<>();
        String sql = """
                        SELECT 
                            facture.factureID AS id, facture.date,
                            patient.firstName AS patientFirstName, patient.lastName AS patientLastName,
                            appointment.date AS appointmentDate,
                            service.title AS reason
                        FROM 
                            facture
                        JOIN
                            appointment ON facture.appoitmentID = appointment.appointmentID
                        JOIN
                            patient ON appointment.patientID = patient.patientID
                        JOIN
                            service ON appointment.serviceID = service.serviceID
                        WHERE
                            facture.isPaid = ? 
                        ORDER BY 
                            facture.factureID DESC
            """;
        
        PreparedStatement query = conn.prepareStatement(sql);
        query.setBoolean(1, modelStatus.getIsPaid());
        
        ResultSet res = query.executeQuery();
        while (res.next()) {
            Dictionary<String, String> data = new Hashtable<>();
            
            data.put("id", res.getString("id"));
            data.put("date", res.getDate("date").toString());
            data.put("patientFirstName", res.getString("patientFirstName"));
            data.put("patientLastName", res.getString("patientLastName"));
            data.put("appointmentDate", res.getDate("appointmentDate").toString());
            data.put("reason", res.getString("reason"));
            data.put("status", modelStatus.getStatus());
            
            listFacture.add(data);
        }
        
        return listFacture.toArray(Dictionary[]::new);
    }
    
    public Dictionary getFactureInfos(int factureID) throws SQLException {
        Dictionary<String, String> factureInfos = new Hashtable<>();
        
        String sql = """
                    SELECT
                        facture.*,
                        appointment.date AS appoitmentDate, appointment.hour AS appointmentHour,
                        user.userName AS doctor,
                        service.title AS reason, service.price, service.serviceID,
                        patient.firstName AS patientFirstName, patient.lastName AS patientLastName, patient.email AS patientEmail, patient.telephone AS patientTel
                    FROM
                        facture
                    JOIN
                        appointment ON facture.appoitmentID = appointment.appointmentID
                    JOIN
                        user ON appointment.doctorID = user.userID
                    JOIN
                        service ON appointment.serviceID = service.serviceID
                    JOIN
                        patient ON appointment.patientID = patient.patientID
                    WHERE
                        facture.factureID = ?
                    ORDER BY 
                        facture.factureID DESC
            """;
        
        PreparedStatement query = conn.prepareStatement(sql);
        query.setInt(1, factureID);
        
        ResultSet res = query.executeQuery();
        if (res.next()) {
            factureInfos.put("factureID", String.valueOf(factureID));
            factureInfos.put("date", res.getDate("date").toString());
            factureInfos.put("isPaid", String.valueOf(res.getBoolean("isPaid")));
            
            factureInfos.put("appoitmentID", res.getString("appoitmentID"));
            factureInfos.put("appoitmentDate", res.getDate("appoitmentDate").toString());
            factureInfos.put("appointmentHour", res.getTime("appointmentHour").toString());
            
            factureInfos.put("doctor", res.getString("doctor"));
            
            factureInfos.put("patientFirstName", res.getString("patientFirstName"));
            factureInfos.put("patientLastName", res.getString("patientLastName"));
            factureInfos.put("patientEmail", res.getString("patientEmail"));
            factureInfos.put("patientTel", res.getString("patientTel"));
            
            factureInfos.put("reason", res.getString("reason"));
            factureInfos.put("price", res.getString("price"));
            factureInfos.put("serviceID", res.getString("serviceID"));
        }
        
        return factureInfos;
    }
    
}
