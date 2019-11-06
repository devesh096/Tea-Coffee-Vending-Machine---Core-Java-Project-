package com.cricfann;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *The class contains various methods to calculate TCVM App Reports.
 * @author Devesh
 */
public class ReportService {
    /**
     * Declare a reference of singleton repository.
     */
    Repository repo = Repository.getRepository();
    
    public String getProductNameById(Integer productId){
        for(Order o: repo.orderList){
            if(o.getProductId().equals(productId)){
                return o.getProductName();
            }
        }
        return null; //no such category id present 
    }
    /**
     * The method calculate month-wise total and returns result in Map.
     * It is preparing data in proper order.
     * @return 
     */
    public Map<String,Float> calculateMonthlyTotal(){
        Map<String,Float> m = new TreeMap();
        for (Order ord : repo.orderList) {
            Date orderDate =  ord.getDate1();
            String yearMonth = DateUtil.getYearAndMonth(orderDate);
            
            if(m.containsKey(yearMonth)){
                //when expense is already present for a month 
                Float total = m.get(yearMonth);
                total=total+ord.getAmount();
                m.put(yearMonth, total); //new total; replace old total 
            } else{
                // this month is not yet added, so add here 
                m.put(yearMonth, ord.getAmount());
            }
        }
        return m;
        }
    /**
     * The method calculate Product-wise total and returns result in Map.
     * It is preparing data in proper order.
     * @return 
     */
    public Map<String,Float> calculateProductTotal(){
        Map<String,Float> m = new TreeMap();
        for (Order ord : repo.orderList) {
           Integer productId=ord.getProductId();
           String productName = this.getProductNameById(productId);
 
            if(m.containsKey(productName)){
                //when expense is already present for a category
                Float total = m.get(productName);
                total=total+ord.getAmount();
                m.put(productName, total); //new total; replace old total 
            } else{
                // this category is not yet added, so add here 
                m.put(productName, ord.getAmount());
            }
        }
        return m;
    }
 
}
