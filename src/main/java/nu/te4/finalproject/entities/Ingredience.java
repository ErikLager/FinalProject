/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.entities;

/**
 *
 * @author Te41905
 */
public class Ingredience {
    private int id;
    private String Commodities;
    private int Recipes_Id;
    private int Ingredience_Id;
    private String Amount;

    public Ingredience(int id, String Commodities, int Recipes_Id, int Ingredience_Id, String Amount) {
        this.id = id;
        this.Commodities = Commodities;
        this.Recipes_Id = Recipes_Id;
        this.Ingredience_Id = Ingredience_Id;
        this.Amount = Amount;
    }

    public Ingredience(int aInt, int aInt0, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodities() {
        return Commodities;
    }

    public void setCommodities(String Commodities) {
        this.Commodities = Commodities;
    }

    public int getRecipes_Id() {
        return Recipes_Id;
    }

    public void setRecipes_Id(int Recipes_Id) {
        this.Recipes_Id = Recipes_Id;
    }

    public int getIngredience_Id() {
        return Ingredience_Id;
    }

    public void setIngredience_Id(int Ingredience_Id) {
        this.Ingredience_Id = Ingredience_Id;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }
}
