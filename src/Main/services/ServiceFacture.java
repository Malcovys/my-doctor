package main.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import main.connection.DatabaseConnection;

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
    
    public void updateIsPaidColone(int appoitementID, boolean isPaid) throws SQLException {
        PreparedStatement query = conn.prepareStatement("UPDATE `facture` SET `isPaid` = ? WHERE `appoitmentID` = ?");
        query.setBoolean(1, isPaid);
        query.setInt(2, appoitementID);
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
    
    public void getFacturesByStatusPaid(boolean  isPaid) {
        
    }
    
}
