package main.controller;

import java.sql.SQLException;
import java.util.Dictionary;
import main.model.ModelAppointment;
import main.model.ModelUser;
import main.services.ServiceRole;
import main.services.ServiceUser;

/**
 *
 * @author malco
 */
public class ControllerUser {
    
    public static String[] getFreeDoctor(String date, String hour) throws SQLException {
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
    
    public static Dictionary[] getUsers() throws SQLException {
        ServiceUser serviceUser = new ServiceUser();
        return serviceUser.getUsers();
    }
    
    public static void createUser(String name, String email, String telephone, String role, String password) throws SQLException{
        ModelUser modelUser = new ModelUser(role, name, telephone, email);
        modelUser.setPassword(password);
        modelUser.setRoleID(ControllerRole.getRoleId(role));
        
        ServiceUser serviceUser = new ServiceUser();
        serviceUser.insertUser(modelUser);
    }
}
