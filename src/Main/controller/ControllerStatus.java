package main.controller;

import java.sql.SQLException;
import main.services.ServiceStatus;

/**
 *
 * @author malco
 */
public class ControllerStatus {
    
    public static String[] getAllStatus() throws SQLException {
        ServiceStatus serviceStatus = new ServiceStatus();
        return serviceStatus.getStatus();
    }
}
