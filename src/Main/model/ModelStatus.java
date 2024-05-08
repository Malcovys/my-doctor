package main.model;

/**
 *
 * @author malco
 */
public class ModelStatus {
    
    private boolean upcoming;
    private boolean complete;
    private boolean desabled;

    public ModelStatus() {
        this.upcoming = false;
        this.complete = false;
        this.desabled = false;
    }
    
    public String getStatus(){
        if(upcoming){
            return "à venir";
        }
        else if(desabled){
            return "annuler";
        }
        else if(complete)
        {
            return "terminer";
        }
        return null;
    }

    public void setUpcoming() {
        this.upcoming = true;
        this.complete = false;
        this.desabled = false;
    }

    public void setComplete() {
        this.complete = true;
        this.desabled = false;
        this.upcoming = false;
    }

    public void setDesabled() {
        this.desabled = true;
        this.complete = false;
        this.upcoming = false;
    }
}
