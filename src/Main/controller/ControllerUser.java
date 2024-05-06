package main.controller;

import java.sql.SQLException;
import main.model.ModelAppointment;
import main.services.ServiceUser;

/**
 *
 * @author malco
 */
public class ControllerUser {
    
    public static String[] getFreeDoctor(String date, String hour) throws SQLException
    {
        ServiceUser serviceUser = new ServiceUser();
        ModelAppointment modelAppointment = new ModelAppointment();
        
        modelAppointment.setDate(date);
        modelAppointment.setHour(hour);
        
        return  serviceUser.getFreeDoctorAt(modelAppointment.getDate(), modelAppointment.getHour());
    }
    
    public static int getIdByName(String name) throws SQLException {
        ServiceUser serviceUser = new ServiceUser();
        return  serviceUser.getUserIDByName(name);
    }
}
