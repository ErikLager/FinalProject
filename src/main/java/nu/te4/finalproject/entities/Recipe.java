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
public class Recipe {
    private int Id;
    private String Name;
    private String Picure;
    private String StepGuide;
    private String [] Commodity;
    private String [] Amount;

    public Recipe(String[] Commodity, String[] Amount) {
        this.Commodity = Commodity;
        this.Amount = Amount;
    }

    public Recipe(int Id, String Name, String Picure, String StepGuide) {
        this.Id = Id;
        this.Name = Name;
        this.Picure = Picure;
        this.StepGuide = StepGuide;
    }
public Recipe(int Id, String Name, String Picure, String StepGuide, String amount, String commodities) {
        this.Id = Id;
        this.Name = Name;
        this.Picure = Picure;
        this.StepGuide = StepGuide;
        
        
    }
  

    public String getStepGuide() {
        return StepGuide;
    }

    public void setStepGuide(String StepGuide) {
        this.StepGuide = StepGuide;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPicure() {
        return Picure;
    }

    public void setPicure(String Picure) {
        this.Picure = Picure;
    }

    public String[] getCommodity() {
        return Commodity;
    }

    public void setCommodity(String[] Commodity) {
        this.Commodity = Commodity;
    }

    public String[] getAmount() {
        return Amount;
    }

    public void setAmount(String[] Amount) {
        this.Amount = Amount;
    }
}
