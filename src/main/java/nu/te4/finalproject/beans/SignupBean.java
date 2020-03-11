/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.beans;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.status;
import static javax.ws.rs.core.Response.status;
import nu.te4.finalproject.backend.ConnectionFactory;
import nu.te4.finalproject.beans.Credentials;

/**
 *
 * @author Te41905
 */
public class SignupBean {
    
//    private static final Logger LOGGER = LoggerFactory.getLogger(SignupBean.class);
    public Response signupUser(String basicAuth){
        
//        Credentials credentials = new Credentials(basicAuth);
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO users (ID, Username, Admin, Oauth_Id, Password) VALUES (NULL, ?, ?, NULL, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
//            stmt.setString(1, );
//            String hashedPassword = BCrypt.withDefaults().hashToString(12, Credentials.getVerifyer().toCharArray());
//            stmt.setString(2, hashedPassword);
        } catch (Exception e) {
        }
        return null;
    }
}
