package main.model;

/**
 *
 * @author malco
 */
public class ModelRole {
    private int roleID;
    private String title;

    public ModelRole(int roleID, String title) {
        this.roleID = roleID;
        this.title = title;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
