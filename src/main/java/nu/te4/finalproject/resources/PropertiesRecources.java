/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.resources;

import com.sun.org.glassfish.gmbal.ParameterNames;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import nu.te4.finalproject.beans.PropertiesBean;

/**
 *
 * @author Erik
 */

@Path("properties")
public class PropertiesRecources {
    @EJB
    PropertiesBean propertiesBean;
    
    @GET
    @Path("{key}")
    public Response getKey(@PathParam("key") String key){
        return Response.ok(propertiesBean.getProp(key)).build();
    }
}
