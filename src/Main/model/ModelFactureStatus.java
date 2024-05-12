package main.model;

/**
 *
 * @author malco
 */
public class ModelFactureStatus {
    private boolean isPaid;

    public ModelFactureStatus() {
        this.isPaid = false;
    }
    
    public void setIsPaid (boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    public boolean getIsPaid() {
        return  this.isPaid;
    }
    
    public String getStatus() {
        if(isPaid) {
            return "payée";
        }else {
            return "impayée";
        }
    }
    
    public String[] getAllStatus()
    {
        return new String[] {"impayée", "payée"};
    }
    
}
