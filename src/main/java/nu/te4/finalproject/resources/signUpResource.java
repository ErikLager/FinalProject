/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.resources;
import java.util.List;
import javafx.scene.media.Media;
import javax.ws.rs.Path;
import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.finalproject.beans.Credentials;
import nu.te4.finalproject.beans.SignupBean;

/**
 *
 * @author Erik
 */

@Path("verify")
@Produces(MediaType.APPLICATION_JSON)
public class signUpResource {
    
    @EJB
    SignupBean signup;
    
    @Path("/verify/{uname}")
    @POST
    public Response getVerified (@PathParam("uname") String uname){
        return Response.ok().build();
        
    }
    
    @Path("/verify/{pword}")
    @POST
    public Response getVerifiedpWord (@PathParam("pword") String pword){
//        String credentials = signup.signupUser(int ID, String Username, String Oauth_Id, String Password);
        return Response.ok(pword).build();
    }
    
}
