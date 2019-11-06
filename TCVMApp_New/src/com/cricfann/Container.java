package com.cricfann;


/**
 *This Class will Store the Quantity of Container and Update it as costumer gives an order.
 * It Will be used to Check Wether Sufficient Quantity of Raw Material is Available or not.
 * @author Devesh
 */
class Container {
    
     private Float tea_container = 2000.0F;
     private Float coffee_container = 2000.0F;
     private Float sugar_container = 8000.0F;
     private Float water_container = 15000.0F;
     private Float milk_container = 10000.0F;

    public Container() {
    }

    public Float getTea_container() {
        return tea_container;
    }

    public void setTea_container(Float tea_container) {
        this.tea_container = tea_container;
    }

    public Float getCoffee_container() {
        return coffee_container;
    }

    public void setCoffee_container(Float coffee_container) {
        this.coffee_container = coffee_container;
    }

    public Float getSugar_container() {
        return sugar_container;
    }

    public void setSugar_container(Float sugar_container) {
        this.sugar_container = sugar_container;
    }

    public Float getWater_container() {
        return water_container;
    }

    public void setWater_container(Float water_container) {
        this.water_container = water_container;
    }

    public Float getMilk_container() {
        return milk_container;
    }

    public void setMilk_container(Float milk_container) {
        this.milk_container = milk_container;
    }
    /**
     * 
     * @param tea_container
     * @param coffee_container
     * @param sugar_container
     * @param water_container
     * @param milk_container 
     */
    public Container(Float tea_container, Float coffee_container, Float sugar_container, Float water_container, Float milk_container) {
        this.tea_container = tea_container;
        this.coffee_container = coffee_container;
        this.sugar_container = sugar_container;
        this.water_container = water_container;
        this.milk_container = milk_container;
    }
     
     
    
}

