package main.controller;

import java.sql.SQLException;
import main.services.ServiceRole;
import main.services.ServiceUser;

/**
 *
 * @author malco
 */
public class ControllerUser {

    public ControllerUser() {}
    
    public String[] getDoctors() throws SQLException {
        ServiceRole serviceRole = new ServiceRole();
        int userRoleID = serviceRole.getRoleIDByTitle("doctor");
        
        ServiceUser serviceUser = new ServiceUser();
        return  serviceUser.getAllNames(userRoleID);
    }
}
