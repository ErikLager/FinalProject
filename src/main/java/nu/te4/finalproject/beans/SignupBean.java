/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ejb.Stateless;
import nu.te4.finalproject.backend.ConnectionFactory;

/**
 *
 * @author Te41905
 */
@Stateless
public class SignupBean {
   

    public String signupUser(String Username) {
        
//        Credentials credentials = new Credentials(int ID, String Username, String Password);
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO users (ID, Username, Password) VALUES (NULL, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Username);
            ResultSet data = stmt.executeQuery();
            int id = data.getInt("Id");
            String un = data.getString("Username");
            String pw = data.getString("Password");
            return id+un+pw;
        } catch (Exception e) {
            System.out.println("Errir in signupUser: " +e.getMessage());
        }
        return null;}
    
    
    public String getVerifiedpWord(String Username, String Password){
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "SELECT Password from `users` where Username= "+"'"+Username+"'";
            if (sql == Password){
                return Username;
            }
            
        } catch (Exception e) {
            System.out.println("Error in getVerified: "+e.getMessage());
        }
        return null;
    }
    

    

    
}
