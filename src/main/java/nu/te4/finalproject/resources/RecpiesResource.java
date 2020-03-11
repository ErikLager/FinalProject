/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.resources;

import java.util.List;
import nu.te4.finalproject.beans.ReciepeBeans;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nu.te4.finalproject.beans.ReciepeBeans;
import nu.te4.finalproject.entities.Ingredience;
import nu.te4.finalproject.entities.Recipe;

/**
 *
 * @author Te41905
 */

@Path("Recipes")
@Produces(MediaType.APPLICATION_JSON)
public class RecpiesResource {
    
    @EJB
    ReciepeBeans finalBeans;
    
    @Path("/search/{name}")
    @GET
    public Response getRecipes (@PathParam("name") String name){
        List<Recipe> recipes = finalBeans.getRecipes(name);
        return Response.ok(recipes).build();
    }
    
    @EJB
    ReciepeBeans commodeties;
    
    @Path("/comm/{id}")
    @GET
    public Response getComm (@PathParam("id") int id){
        List<Recipe> comm = finalBeans.getComm(id);
    }
}
