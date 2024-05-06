package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import main.connection.DatabaseConnection;

/**
 *
 * @author malco
 */
public class ServiceServices {
    private final Connection conn;

    public ServiceServices() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public int getId(String title) throws SQLException {
        int id = -1;
        
        PreparedStatement query = conn.prepareStatement("SELECT `serviceID` FROM `service` WHERE `title` = ?");
        query.setString(1, title);
        
        ResultSet res = query.executeQuery();
        if(res.next()) {
           id = res.getInt("serviceID");
        }
        
        return  id;
    }
    
    public String[] getAllTile() throws SQLException {
        List<String> serviceList = new ArrayList<>();
       
       String sql = "SELECT `title` FROM `service`";
       PreparedStatement query = conn.prepareStatement(sql);
       
       ResultSet res = query.executeQuery();
        while (res.next()) {
            serviceList.add(res.getString("title"));
        }
        
       return serviceList.toArray(String[]::new);
    }
    
    public Time getServiceDuration(String title) throws SQLException {
        String sql = "SELECT `duration` FROM `service` WHERE `title` = ?";

        PreparedStatement query = conn.prepareStatement(sql);
        query.setString(1, title);

        ResultSet res = query.executeQuery();
        if (res.next()) {
            Time duration = res.getTime("duration");
            return duration;
        } else {
            return null;
        }
    }

}
