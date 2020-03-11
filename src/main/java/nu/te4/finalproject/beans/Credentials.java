/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.beans;

/**
 *
 * @author Te41905
 */
public class Credentials {
    private int ID;
    private String Username;
    private boolean Admin;
    private String Oauth_Id;
    private String Password;
    private String Verifyer;

    public Credentials(int ID, String Username, boolean Admin, String Oauth_Id, String Password, String Verifyer) {
        this.ID = ID;
        this.Username = Username;
        this.Admin = Admin;
        this.Oauth_Id = Oauth_Id;
        this.Password = Password;
        this.Verifyer = Verifyer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean Admin) {
        this.Admin = Admin;
    }

    public String getOauth_Id() {
        return Oauth_Id;
    }

    public void setOauth_Id(String Oauth_Id) {
        this.Oauth_Id = Oauth_Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getVerifyer() {
        return Verifyer;
    }

    public void setVerifyer(String Verifyer) {
        this.Verifyer = Verifyer;
    }
    
    
}
