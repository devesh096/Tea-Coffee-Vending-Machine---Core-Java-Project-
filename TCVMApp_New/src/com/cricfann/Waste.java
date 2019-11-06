/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cricfann;

/**
 *This Class will Keep Record of the Waste Material while taking Order from the Customers
 * @author Devesh
 */
class Waste {
    
    private Float coffeewaste = 0.0F;
    private Float teawaste = 0.0F;
    private Float sugarwaste = 0.0F;
    private Float milkwaste = 0.0F;
    private Float waterwaste = 0.0F;

    public Waste() {
    }

    public Float getCoffeewaste() {
        return coffeewaste;
    }

    public void setCoffeewaste(Float coffeewaste) {
        this.coffeewaste = coffeewaste;
    }

    public Float getTeawaste() {
        return teawaste;
    }

    public void setTeawaste(Float teawaste) {
        this.teawaste = teawaste;
    }

    public Float getSugarwaste() {
        return sugarwaste;
    }

    public void setSugarwaste(Float sugarwaste) {
        this.sugarwaste = sugarwaste;
    }

    public Float getMilkwaste() {
        return milkwaste;
    }

    public void setMilkwaste(Float milkwaste) {
        this.milkwaste = milkwaste;
    }

    public Float getWaterwaste() {
        return waterwaste;
    }

    public void setWaterwaste(Float waterwaste) {
        this.waterwaste = waterwaste;
    }

    /**
     * 
     * @param coffeewaste
     * @param teawaste
     * @param sugarwaste
     * @param milkwaste
     * @param waterwaste 
     */
    public Waste(Float coffeewaste, Float teawaste, Float sugarwaste, Float milkwaste, Float waterwaste) {
        this.coffeewaste = coffeewaste;
        this.teawaste = teawaste;
        this.sugarwaste = sugarwaste;
        this.milkwaste = milkwaste;
        this.waterwaste = waterwaste;
    }
    
    
    
}
