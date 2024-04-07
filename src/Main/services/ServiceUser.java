package main.services;

import main.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        PreparedStatement p = conn.prepareStatement("INSERT INTO `user` (`userName`, `email`, `password`) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int userID = r.getInt(1);
        r.close();
        p.close();
        user.setUserID(userID);
    }
    
    public boolean checkDuplicateUser(String user) throws  SQLException {
        boolean duplicate = false;
        PreparedStatement query = conn.prepareStatement("select UserID form `user` where `userName`=? limit 1");
        query.setString(0, user);
        ResultSet response = query.executeQuery();
        if(response.first()) {
            duplicate = true;
        }
        response.close();
        query.close();
        return duplicate;
    }
    
    public boolean checkDuplicateEmail(String email) throws  SQLException {
        boolean duplicate = false;
        PreparedStatement query = conn.prepareStatement("select UserID form `user` where `email`=? limit 1");
        query.setString(0, email);
        ResultSet response = query.executeQuery();
        if(response.first()) {
            duplicate = true;
        }
        response.close();
        query.close();
        return duplicate;
    }
}
