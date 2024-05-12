package main.controller;

import java.sql.SQLException;
import java.util.Dictionary;
import main.model.ModelFactureStatus;
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
    
    public static void pay(int factureID) throws SQLException {
        ServiceFacture serviceFacture = new ServiceFacture();
        serviceFacture.updateIsPaidColone(factureID, true);
    }
    
    public static boolean verifieIfExistByAppoitementID(int appoitementID) throws SQLException {
        boolean isExist = false;
        ServiceFacture serviceFacture = new ServiceFacture();
        if(serviceFacture.getFactureIDByAppoitementID(appoitementID) != -1) {
            isExist = true;
        }
        return isExist;
    }
    
    public static String[] getFactureStatus() {
        ModelFactureStatus modelFactureStatus = new ModelFactureStatus();
        return modelFactureStatus.getAllStatus();
    }
    
    public static Dictionary[] getUnpaidFactures() throws SQLException {
        ModelFactureStatus modelFactureStatus = new ModelFactureStatus();
        modelFactureStatus.setIsPaid(false);
        ServiceFacture serviceFacture = new ServiceFacture();
        return serviceFacture.getFacturesByPaidStatus(modelFactureStatus);
    }
    
     public static Dictionary[] getPaidFactures() throws SQLException {
        ModelFactureStatus modelFactureStatus = new ModelFactureStatus();
        modelFactureStatus.setIsPaid(true);
        ServiceFacture serviceFacture = new ServiceFacture();
        return serviceFacture.getFacturesByPaidStatus(modelFactureStatus);
    }
     
    public static Dictionary getFactureInfos(int factureID) throws SQLException {
        ServiceFacture serviceFacture = new ServiceFacture();
        return serviceFacture.getFactureInfos(factureID);
    }
}
