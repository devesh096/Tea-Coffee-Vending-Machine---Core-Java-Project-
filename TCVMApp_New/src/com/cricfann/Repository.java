package com.cricfann;


import java.util.ArrayList;
import java.util.List;


/**
 * The class is used as Database/Repository and its a singleton.
 * @author Devesh
 */
public class Repository {
    
     /**
     * The List holds all Container and their quantites.
     */
    public List<Container> container = new ArrayList();
     /**
     * The List holds all Orders given by Customers.
     */
    public List<Order> orderList = new ArrayList();
     /**
     * The List holds all Quantity of Waste of each order.
     */
    public List<Waste> wasteList = new ArrayList();
    
    private static Repository repository;
    
    /**
     * Private constructor to restrict object creation from Outside.
     */
    private Repository(){  
    }

    /**
     * The method provides a singleton object of repository.
     * @return 
     */
    public static Repository getRepository(){
    if(repository==null){
        repository = new Repository();
    }
    return repository;
    }
}
