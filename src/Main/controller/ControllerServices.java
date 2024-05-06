package main.controller;

import java.sql.SQLException;
import java.time.LocalTime;
import main.services.ServiceServices;

/**
 *
 * @author malco
 */
public class ControllerServices {
    
    public static String[] getAllServicesTitle() throws SQLException {
        ServiceServices services = new ServiceServices();
        return  services.getAllTile();
    }
    
    public static int getIdOf(String title) throws SQLException {
        ServiceServices services = new ServiceServices();
        return services.getId(title); 
    }
    
    public static LocalTime calculateEndHour(LocalTime hour, String reason) throws SQLException {
        ServiceServices services = new ServiceServices();
        LocalTime serviceDuration = services.getServiceDuration(reason).toLocalTime();
        
        return hour.plusHours(serviceDuration.getHour()).plusMinutes(serviceDuration.getMinute());
    }
}
