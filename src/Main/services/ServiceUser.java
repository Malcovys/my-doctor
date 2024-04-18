package main.services;

import main.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
                        + "VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        query.setInt(1, user.getRoleID());
        query.setString(2, user.getUser_name());
        query.setString(4, user.getEmail());
        query.setString(5, user.getTelephone());
        query.setString(6, user.getPassword());
        query.execute();
        
        ResultSet res = query.getGeneratedKeys();
        res.first();
        int userID = res.getInt(1);
        res.close();
        res.close();
        user.setUserID(userID);
    }
    
   public String[] getAllNames(int roleID) throws SQLException {
        List<String> userNamesList = new ArrayList<>();
        try (PreparedStatement query = conn.prepareStatement("select `userName` from `user` where `roleID` = ?")) {
            query.setInt(1, roleID);
            try (ResultSet res = query.executeQuery()) {
                while (res.next()) {
                    userNamesList.add(res.getString("userName"));
                }
            }
        }
        return userNamesList.toArray(String[]::new);
    }

    
    public int getUserIDByName(String userName) throws SQLException {
        int userId = -1;
        try (PreparedStatement query = conn.prepareStatement("select `userID` from `user` where `userName`=?")) {
            query.setString(1, userName);
            try (ResultSet res = query.executeQuery()) {
                if (res.next()) {
                    userId = res.getInt("UserID");
                }
            }
        }
        return userId;
    }
    
    public boolean authUser(String email, String password) throws  SQLException {
        boolean authenticated = false;
        try (PreparedStatement query = conn.prepareStatement("select `userID` from `user` where `email`=? and password=?")) {
            query.setString(1, email);
            query.setString(2, password);
            try (ResultSet res = query.executeQuery()) {
                if(res.next()) {
                    authenticated = true;
                }
            }
        }
        return authenticated;
    }
}
