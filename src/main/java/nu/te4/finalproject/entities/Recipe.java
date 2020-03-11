/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.finalproject.entities;

import java.util.List;

/**
 *
 * @author Te41905
 */
public class Recipe {
    private int Id;
    private String Name;
    private String Picure;
    private String StepGuide;
    private List<String> Commodity;

    
    public Recipe(int Id, String Name, String Picure, String StepGuide, List<String> commodities) {
        this.Id = Id;
        this.Name = Name;
        this.Picure = Picure;
        this.StepGuide = StepGuide;
        this.Commodity = commodities;
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

    public List<String> getCommodity() {
        return Commodity;
    }

    public void setCommodity(List<String> Commodity) {
        this.Commodity = Commodity;
    }

    
}
