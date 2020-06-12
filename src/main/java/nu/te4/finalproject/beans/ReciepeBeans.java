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
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import nu.te4.finalproject.backend.ConnectionFactory;
import nu.te4.finalproject.entities.Recipe;

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
            String sql = "SELECT * FROM recipes WHERE name=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            System.out.println(stmt.toString());
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                System.out.println("Entered while-loop");
                int id = data.getInt("Id");
                String n = data.getString("Name");
                String pic = data.getString("Picture");
                String sg = data.getString("StepGuide");
                List<String> commodities = getComm(id);
                recipes.add(new Recipe(id, n, pic, sg, commodities));
            }
            return recipes;

        } catch (Exception e) {
            System.out.println("Error in 'getRecipes()'" + e.getMessage());
        }
        return null;
    }

    public List<String> getComm(int id) {
        List<String> commodities = new LinkedList();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            System.out.println("Getting commodities");
            String sql = "SELECT * FROM `recipe_commodities` WHERE Recipes_Id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet data = stmt.executeQuery();
            while (data.next()) {
                String amount = data.getString("Amount");
                String commodity = data.getString("Commodities");
                commodities.add(amount + " " + commodity);
            }
        } catch (Exception e) {
            System.out.println("Error in 'getComm()': " + e.getMessage());
        }
        return commodities;
    }

    public List<Recipe> randomRecipe() {
        List<Recipe> recipes = new ArrayList();
        System.out.println("List Created");
        try ( Connection connection = ConnectionFactory.getConnection()) {
            String sql = "SELECT name FROM recipes";
            System.out.println("SQL question declared");
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println("prepared stmt");
            ResultSet data = stmt.executeQuery();
            System.out.println("Resultset data");
            while (data.next()) {
                System.out.println("Entered while-loop");
                String n = data.getString("Name");
                recipes.add(new Recipe(0, n, null, null, null));
                System.out.println("List element added");
            }
            return recipes;
        } catch (Exception e) {
            System.out.println("Error in 'getRandom()': " + e.getMessage());
        }
        return null;
    }
    public List<Recipe> addRecipe(){
        List<Recipe> newrec = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()){
            String sql = "INSERT INTO `recipes` (`Id`, `Name`, `Picture`, `StepGuide`) VALUES (NULL, ?, ?, ?);";
            PreparedStatement stmt = connection.prepareStatement(sql);
            newrec.add((Recipe) stmt);
            
        } catch (Exception e) {
            System.out.println("Error in addRecipe():"+e.getMessage());
        }
        return null;
    }
}
