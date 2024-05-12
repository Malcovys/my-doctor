package main.services;

import main.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import main.model.ModelUser;

/**
 *
 * @author malco
 */
public class ServiceUser {
    
    private final Connection conn;
    
    public ServiceUser() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public void insertUser(ModelUser user) throws SQLException {
        PreparedStatement query = conn.prepareStatement(
                "INSERT INTO `user` (`roleID`, `userName`, `email`, `telephone`, `password`) "
                        + "VALUES (?, ?, ?, ?, ?)");
        query.setInt(1, user.getRoleID());
        query.setString(2, user.getUser_name());
        query.setString(3, user.getEmail());
        query.setString(4, user.getTelephone());
        query.setString(5, user.getPassword());
        query.execute();
    }
    
   public String[] getAllNames(int roleID) throws SQLException {
        List<String> userNamesList = new ArrayList<>();
        PreparedStatement query = conn.prepareStatement("select `userName` from `user` where `roleID` = ?");
        query.setInt(1, roleID);
        
        ResultSet res = query.executeQuery();
        while (res.next()) {
            userNamesList.add(res.getString("userName"));
        }
        
        return userNamesList.toArray(String[]::new);
    }
   
    public  String[] getFreeDoctorAt(LocalDate date, LocalTime hour) throws SQLException {
       List<String> freeDoctorList = new ArrayList<>();
       
       String sql = """
            SELECT u.userName FROM user u
            JOIN role r ON u.roleID = r.roleID
            WHERE r.title = 'doctor'
            AND u.userID NOT IN (
            SELECT a.doctorID
            FROM appointment a
            WHERE a.date =? AND a.endHour >= ? AND a.appoitement_statusID = (
                    SELECT appoitementstatus.appoitement_statusID
                    FROM appoitementstatus
                    WHERE appoitementstatus.status = "à venir"
                )
            )                                           
        """;
       
        PreparedStatement query = conn.prepareStatement(sql);
        query.setDate(1, Date.valueOf(date));
        query.setTime(2, Time.valueOf(hour));
             
        ResultSet res = query.executeQuery();
        while (res.next()) {
            freeDoctorList.add(res.getString("userName"));
        }
        
       return freeDoctorList.toArray(String[]::new);
    }

    
    public int getUserIDByName(String userName) throws SQLException {
        int userId = -1;
        PreparedStatement query = conn.prepareStatement("select `userID` from `user` where `userName`=?");
        query.setString(1, userName);
        
        ResultSet res = query.executeQuery();
        if (res.next()) {
            userId = res.getInt("UserID");
        }
            
        return userId;
    }
    
    public boolean authUser(String email, String password) throws  SQLException {
        boolean authenticated = false;
        
        PreparedStatement query = conn.prepareStatement("select `userID` from `user` where `email`=? and password=?");
        query.setString(1, email);
        query.setString(2, password);
        
        ResultSet res = query.executeQuery();
        if(res.next()) {
            authenticated = true;
        }
        
        return authenticated;
    }
    
    public Dictionary[] getUsers() throws SQLException {
        List<Dictionary> listUser = new ArrayList<>();
        String sql = """
                SELECT 
                    user.userID AS id, user.userName AS name, user.email, user.telephone,
                    role.title AS poste
                FROM
                    user
                JOIN
                    role ON user.roleID = role.roleID
                WHERE 
                    user.telephone != 'NULL'
                ORDER BY 
                    user.userID DESC
              """;
        PreparedStatement query = conn.prepareStatement(sql);
        ResultSet res = query.executeQuery();
        while (res.next()) {
            Dictionary<String,String> userInfos = new Hashtable<>();
            userInfos.put("id", res.getString("id"));
            userInfos.put("name",res.getString("name"));
            userInfos.put("email",res.getString("email"));
            userInfos.put("telephone",res.getString("telephone"));
            userInfos.put("poste",res.getString("poste"));
            listUser.add(userInfos);
        }
        return listUser.toArray(Dictionary[]::new);
    }
}
