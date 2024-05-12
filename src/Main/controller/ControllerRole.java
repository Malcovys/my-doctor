package main.controller;

import java.sql.SQLException;
import main.services.ServiceRole;

/**
 *
 * @author malco
 */
public class ControllerRole {
    
    public static String[] getRolesTitle() throws SQLException {
        ServiceRole serviceRole = new ServiceRole();
        return  serviceRole.getRolesTitle();
    }
    
    public static int getRoleId(String role) throws SQLException {
        ServiceRole serviceRole = new ServiceRole();
        return  serviceRole.getRoleIDByTitle(role);
    }
}
