/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Id;
import javax.ws.rs.core.Response;
import nu.te4.finalproject.backend.ConnectionFactory;
import nu.te4.finalproject.entities.Ingredience;
import nu.te4.finalproject.entities.Recipe;
import sun.awt.www.content.image.gif;

/**
 *
 * @author L
 */
@Stateless
public class ReciepeBeans {

    public List<Recipe> getRecipes(String name) {
        List<Recipe> recipes = new ArrayList();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            System.out.println("Getting recipes");
            String sql = "SELECT `recipes_ingredience`.`Amount`, `ingredience`.`Commodities`, `recipes`.*\n"
                    + "FROM `recipes_ingredience` \n"
                    + "	LEFT JOIN `ingredience` ON `recipes_ingredience`.`Ingredience_Id` = `ingredience`.`Id` \n"
                    + "	LEFT JOIN `recipes` ON `recipes_ingredience`.`Recipes_Id` = `recipes`.`Id`WHERE recipes.Name = ?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            System.out.println(stmt.toString());
            ResultSet data = stmt.executeQuery();
            System.out.println("Data created");
            while (data.next()) {
                System.out.println("Entered while-loop");
                int id = data.getInt("Id");
                String n = data.getString("Name");
                String pic = data.getString("Picture");
                String sg = data.getString("StepGuide");
                while (data.next()) {
                    String amount = data.getString("Amount");
                    String c = data.getString("Commodities");
                    Recipe r = new Recipe(id, n, pic, sg, amount, c);
                    recipes.add(r);
                }

            }
            return recipes;

        } catch (Exception e) {
            System.out.println("Error in 'getRecipes()'" + e.getMessage());
        }
        return null;
    }
    public List<Recipe> getComm (int id){
        List<Recipe> comm = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()){
            System.out.println("Getting commodities");
            String sql = "SELECT * FROM ";//Help from Daniel
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);//Check, i'm unsure
            ResultSet data = stmt.executeQuery();
            while (data.next()){
                
            }
        } catch (Exception e) {
            System.out.println("Error in 'getComm()': "+ e.getMessage());
        }
        return null;
    }
}
