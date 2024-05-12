package main.controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Dictionary;
import main.model.ModelService;
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
    
    public static Dictionary[] getServices() throws SQLException {
        ServiceServices services = new ServiceServices();
        return services.getServices();
    }
    
    public static void createService(String title, String duration, int price) throws SQLException {
        ModelService modelService = new ModelService(title, duration, price);
        ServiceServices services = new ServiceServices();
        services.insert(modelService);
    }
}
