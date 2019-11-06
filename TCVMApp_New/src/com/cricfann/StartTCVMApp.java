package com.cricfann;


/**
 * *This class is an entry point of execution for Tea Coffee Vending Machine Application (TCVM App).

 * @author Devesh
 */
public class StartTCVMApp {

    /**
     * This method is creating <code>TCVMService</code> Object and show 
     * app menu by calling showMenu() method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TCVMService service = new TCVMService();
        service.showMenu();
    }
    
}
