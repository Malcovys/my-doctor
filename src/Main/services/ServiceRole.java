package main.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.connection.DatabaseConnection;

/**
 *
 * @author malco
 */
public class ServiceRole {
    private final Connection conn;
    
    public ServiceRole() {
        conn = DatabaseConnection.getInstance().getConnection();
    }
    
    public int getRoleIDByTitle(String title) throws SQLException {
        int roleID = -1;
        try (PreparedStatement query = conn.prepareStatement("select `roleID` from `role` where `title`=?")) {
            query.setString(1, title);
            try (ResultSet res = query.executeQuery()) {
                if (res.next()) {
                    roleID = res.getInt("roleID");
                }
            }
        }
        return roleID;
    }
}
