package main.model;

/**
 *
 * @author malco
 */
public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private int userID;
    private int roleID;
    private String role;
    private String user_name;
    private String telephone;
    private String email;
    private String password;

    public ModelUser(String role, String user_name, String telephone, String email) {
        this.role = role;
        this.user_name = user_name;
        this.telephone = telephone;
        this.email = email;
    }

    public ModelUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
  
}
