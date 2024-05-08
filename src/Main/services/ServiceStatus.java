package main.services;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.connection.DatabaseConnection;
/**
 *
 * @author malco
 */
public class ServiceStatus {
    private final Connection conn;
    
    public ServiceStatus() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public String[] getStatus() throws SQLException{
        List<String> statusList = new ArrayList<>();
        
        PreparedStatement query = conn.prepareStatement("SELECT `status` FROM `appoitementstatus`");
        
        ResultSet res = query.executeQuery();
        
        while (res.next()) {            
            statusList.add(res.getString("status"));
        }
        
        return statusList.toArray(String[]::new);
    }
}
