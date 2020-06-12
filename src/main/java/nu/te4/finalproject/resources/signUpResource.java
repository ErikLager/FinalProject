/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.resources;
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

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class signUpResource {
    
    @EJB
    SignupBean signup;
    
    @Path("create/user")
    @POST
    public Response createUser (Credentials cred){
        if(signup.createUser(cred) > 0){ //<---- Fix that
        return Response.status(Response.Status.CREATED).build();
        }else{
                return Response.status(Response.Status.BAD_REQUEST).build();

        }
        
    }
    
    @Path("/verify/user")
    @POST
    public Response getVerifiedpWord (Credentials cred){
        if(signup.checkUser(cred)){
        return Response.ok().build();
        }else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
    }
    
}
