package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import main.connection.DatabaseConnection;
import main.model.ModelService;

/**
 *
 * @author malco
 */
public class ServiceServices {
    private final Connection conn;

    public ServiceServices() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void insert(ModelService service) throws SQLException {
        PreparedStatement query = conn.prepareStatement("INSERT INTO `service` (`title`, `price`, `duration`) VALUES (?,?,?)");
        query.setString(1, service.getTitle());
        query.setInt(2, service.getPrice());
        query.setTime(3, Time.valueOf(service.getDuration()));
        query.execute();
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
    
    public Dictionary[] getServices() throws SQLException {
        List<Dictionary> listServices = new ArrayList<>();
        PreparedStatement query = conn.prepareStatement("SELECT * FROM service");
        ResultSet res = query.executeQuery();
        while (res.next()) {
            Dictionary<String,String> userInfos = new Hashtable<>();
            userInfos.put("id", res.getString("serviceID"));
            userInfos.put("title",res.getString("title"));
            userInfos.put("price",res.getString("price"));
            userInfos.put("duration",res.getString("duration"));
            listServices.add(userInfos);
        }
        return listServices.toArray(Dictionary[]::new);
    }

}
