package main.controller;

import java.sql.SQLException;
import main.services.ServiceFacture;

/**
 *
 * @author malco
 */
public class ControllerFacture {
    
    public static void generateFactureForAppoitement(int appoitementID) throws SQLException {
        ServiceFacture serviceFacture = new ServiceFacture();
        serviceFacture.insertFacture(appoitementID);
    }
    
    public static void pay(int appoitementID) throws SQLException {
        ServiceFacture serviceFacture = new ServiceFacture();
        serviceFacture.updateIsPaidColone(appoitementID, true);
    }
    
    public static boolean verifieIfExistByAppoitementID(int appoitementID) throws SQLException {
        boolean isExist = false;
        ServiceFacture serviceFacture = new ServiceFacture();
        if(serviceFacture.getFactureIDByAppoitementID(appoitementID) != -1) {
            isExist = true;
        }
        return isExist;
    }
}
