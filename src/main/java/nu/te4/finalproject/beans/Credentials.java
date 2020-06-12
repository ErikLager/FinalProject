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
    private String Password;

    public Credentials(int ID, String Username, String Password) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
    }

    
    /*
    
    {
        ID:1,
        'username':'Erik',
        'Password':'tyest'
    }
    
    
    */
    Credentials() {
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
