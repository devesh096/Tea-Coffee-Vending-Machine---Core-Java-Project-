package com.cricfann;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * The class contains most of the operations related to TCVM Application.
 * <p> 
 * This class prepares a menu and various methods are present to handle the user action.
 * The class make use of <code>Repository</code> to store the data. Also using <code>ReportService</code> to generate different
 * required reports.
 * </p>
 * @author devesh
 */


public class TCVMService {
    /**
    * Declare a reference of repository by calling a static method.This static method which returns a singleton repository object .
    */
    Repository repo = Repository.getRepository();
    /**
     * Declare a reference of Container to call different method and to update quantities on container.
     */
    Container cont = new Container();
    /**
     * Declare a reference of Waste to call different method to calculate Waste from every individual order.
     */
    Waste waste = new Waste();
    /**
     * Declare a reference of ReportService to call different method to calculate reports.
     */
    ReportService reportService = new ReportService();
    /**
     * This variable store the value of menu-choice.
     */
    private int choice;
    /**
     * Decalre a scanner object to take Standard input from keyboard.
     */
    Scanner in = new Scanner(System.in);
  
   /**
     * This method prepares a TCVM Application Menu using switch case and infinite loop. Also Ask for user choice.
     */
    public void showMenu(){
        while(true){
            printMenu();
            switch(choice){
                case 1:                                   
                    onMakeCoffee();
                    pressAnyKeytoContinue();
                    break;
                case 2:                                   
                    onMakeTea();
                    pressAnyKeytoContinue();
                    break;
                case 3:                                   
                    onMakeBlackCoffee();
                    pressAnyKeytoContinue();
                    break;
                case 4:                                   
                    onMakeBlackTea();
                    pressAnyKeytoContinue();
                    break;
                case 5:                                   
                    onRefillContainer();
                    pressAnyKeytoContinue();
                    break;
                case 6:                                   
                    onCheckTotalSale();
                    pressAnyKeytoContinue();
                    break;
                case 7:                                   
                    onContainerStatus();
                    pressAnyKeytoContinue();
                    break;
                case 8:                                   
                    onResetContainer();
                    pressAnyKeytoContinue();
                    break;
                case 9:
                    onShowWaste();
                    pressAnyKeytoContinue();
                    break;
                case 10:
                    onShowMonthlyOrderList();
                    pressAnyKeytoContinue();
                    break;    
                case 11:
                    onProductWiseSales();
                    pressAnyKeytoContinue();
                    break;
                case 0:
                    //todo add category logic 
                    onExit();
                    break;                                    
            } 
        }
    }
    /**
     * This method Prints a Menu(CUI/CLI menu).
     */
    public void printMenu(){
        System.out.println("-------TCVM Menu------");
        System.out.println("1.Make Coffee");
        System.out.println("2.Make Tea");
        System.out.println("3.Make Black Coffee");
        System.out.println("4.Make Black Tea");
        System.out.println("5.Refill Container ");
        System.out.println("6.Check Total Sale ");
        System.out.println("7.Container Status ");
        System.out.println("8.Reset Container  ");
        System.out.println("9.Show Waste ");
        System.out.println("10.Show Monthly Order List ");
        System.out.println("11.Show Drink Wise Sales Report ");
        System.out.println("0.Exit TCVM  ");
        System.out.println("----------------- ");
        System.out.print("Enter Your Choice--");
        choice=in.nextInt();
    }

    /**
     * This Method will Make Coffee for the User.
     * It will check whether sufficient raw material is available or not
     * It will calculate the waste and update the quantities of container
     */    
       public void onMakeCoffee(){
           in.nextLine();
           
        System.out.println("Welcome to TCVM, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 1;
        String productName = "Coffee";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Coffee Do You Want to Order");
        Integer coffeeQuantity = in.nextInt();
        Float amount = coffeeQuantity*15.0F;
        System.out.println("Any Remark/Instructions");
        in.nextLine();
        String remark = in.nextLine();
        
        if(cont.getCoffee_container()>(5*coffeeQuantity) && cont.getWater_container()>(23*coffeeQuantity) && 
                cont.getMilk_container()>(88*coffeeQuantity) && cont.getSugar_container()>(17*coffeeQuantity)){
        
        Order order = new Order(productName,productId,amount,coffeeQuantity,remark,customerName,customerMobile);
        repo.orderList.add(order);
        System.out.println("Taking Your Order Please Wait for a while");
        
           System.out.println("Your Order is Ready. Please pay Rs."+amount+".");
           
           Float coffeewaste = coffeeQuantity*1.0F;
           Float waterwaste = coffeeQuantity*3.0F;
           Float milkwaste = coffeeQuantity*8.0F;
           Float sugarwaste = coffeeQuantity*2.0F;
           Float teawaste = coffeeQuantity*0.0F;
           
           
           
           cont.setCoffee_container(cont.getCoffee_container() - coffeeQuantity*5);
           cont.setWater_container(cont.getWater_container() - coffeeQuantity*23);
           cont.setMilk_container(cont.getMilk_container() - coffeeQuantity*88);
           cont.setSugar_container(cont.getSugar_container() - coffeeQuantity*17);
           
           waste.setCoffeewaste(waste.getCoffeewaste()+coffeewaste);
           waste.setWaterwaste(waste.getWaterwaste()+waterwaste);
           waste.setMilkwaste(waste.getMilkwaste()+milkwaste);
           waste.setSugarwaste(waste.getSugarwaste()+sugarwaste);
           waste.setTeawaste(waste.getTeawaste()+teawaste);
           
           
       }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
       }
    /**
    * This method is called to hold a output screen after processing the requested task and wait for any char input to continue to the menu.
    */
        public void pressAnyKeytoContinue(){
            try {
                System.out.println("Press Any Key to continue");
                System.in.read();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    /**
     * This Method will Make Tea for the User.
     * It will check whether sufficient raw material is available or not
     * It will calculate the waste and update the quantities of container
     */      
    private void onMakeTea() {
        in.nextLine();
           
        System.out.println("Welcome to TCVM, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 2;
        String productName = "Tea";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Tea Do You Want to Order");
        Integer teaQuantity = in.nextInt();
        Float amount = teaQuantity*10.0F;
        System.out.println("Any Remark/Instructions");
        in.nextLine();
        String remark = in.nextLine();
        
        if(cont.getTea_container()>(6*teaQuantity) && cont.getWater_container()>(65*teaQuantity) && 
                cont.getMilk_container()>(44*teaQuantity) && cont.getSugar_container()>(17*teaQuantity)){
        
        Order order = new Order(productName,productId,amount,teaQuantity,remark,customerName,customerMobile);
        repo.orderList.add(order);
        System.out.println("Taking Your Order Please Wait for a while");
        
           System.out.println("Your Order is Ready. Please pay Rs."+amount+".");
           
           Float coffeewaste = teaQuantity*0.0F;
           Float waterwaste = teaQuantity*5.0F;
           Float milkwaste = teaQuantity*4.0F;
           Float sugarwaste = teaQuantity*2.0F;
           Float teawaste = teaQuantity*1.0F;
           
           cont.setCoffee_container(cont.getCoffee_container() - teaQuantity*0);
           cont.setWater_container(cont.getWater_container() - teaQuantity*65);
           cont.setMilk_container(cont.getMilk_container() - teaQuantity*44);
           cont.setSugar_container(cont.getSugar_container() - teaQuantity*17);
           cont.setTea_container(cont.getTea_container() - teaQuantity*6);
           
           waste.setCoffeewaste(waste.getCoffeewaste()+coffeewaste);
           waste.setWaterwaste(waste.getWaterwaste()+waterwaste);
           waste.setMilkwaste(waste.getMilkwaste()+milkwaste);
           waste.setSugarwaste(waste.getSugarwaste()+sugarwaste);
           waste.setTeawaste(waste.getTeawaste()+teawaste);
           
           
       }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Make Black Coffee for the User.
     * It will check whether sufficient raw material is available or not
     * It will calculate the waste and update the quantities of container
     */  
    private void onMakeBlackCoffee() {
        in.nextLine();
           
        System.out.println("Welcome to TCVM, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 3;
        String productName = "Black Coffee";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Black Coffee Do You Want to Order");
        Integer blackCofeeQuantity = in.nextInt();
        Float amount = blackCofeeQuantity*10.0F;
        System.out.println("Any Remark/Instructions");
        in.nextLine();
        String remark = in.nextLine();
        
        if(cont.getCoffee_container()>=(3*blackCofeeQuantity) && cont.getWater_container()>=(112*blackCofeeQuantity) && 
                cont.getMilk_container()>=(0*blackCofeeQuantity) && cont.getSugar_container()>=(17*blackCofeeQuantity)){
        
        Order order = new Order(productName,productId,amount,blackCofeeQuantity,remark,customerName,customerMobile);
        repo.orderList.add(order);
        System.out.println("Taking Your Order Please Wait for a while");
        
           System.out.println("Your Order is Ready. Please pay Rs."+amount+".");
           
           Float coffeewaste = blackCofeeQuantity*0.0F;
           Float waterwaste = blackCofeeQuantity*12.0F;
           Float milkwaste = blackCofeeQuantity*0.0F;
           Float sugarwaste = blackCofeeQuantity*2.0F;
           Float teawaste = blackCofeeQuantity*0.0F;
           
           cont.setCoffee_container(cont.getCoffee_container() - blackCofeeQuantity*3);
           cont.setWater_container(cont.getWater_container() - blackCofeeQuantity*112);
           cont.setMilk_container(cont.getMilk_container() - blackCofeeQuantity*0);
           cont.setSugar_container(cont.getSugar_container() - blackCofeeQuantity*17);
           cont.setTea_container(cont.getTea_container() - blackCofeeQuantity*0);
           
           waste.setCoffeewaste(waste.getCoffeewaste()+coffeewaste);
           waste.setWaterwaste(waste.getWaterwaste()+waterwaste);
           waste.setMilkwaste(waste.getMilkwaste()+milkwaste);
           waste.setSugarwaste(waste.getSugarwaste()+sugarwaste);
           waste.setTeawaste(waste.getTeawaste()+teawaste);
           
           
       }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Make Black Tea for the User.
     * It will check whether sufficient raw material is available or not
     * It will calculate the waste and update the quantities of container
     */  
    private void onMakeBlackTea() {
        in.nextLine();
           
        System.out.println("Welcome to TCVM, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 4;
        String productName = "Black Tea";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Black Tea Do You Want to Order");
        Integer blackTeaQuantity = in.nextInt();
        Float amount = blackTeaQuantity*5.0F;
        System.out.println("Any Remark/Instructions");
        in.nextLine();
        String remark = in.nextLine();
        
        if(cont.getTea_container()>=(3*blackTeaQuantity) && cont.getWater_container()>=(112*blackTeaQuantity) && 
                cont.getMilk_container()>=(0*blackTeaQuantity) && cont.getSugar_container()>=(17*blackTeaQuantity)){
        
        Order order = new Order(productName,productId,amount,blackTeaQuantity,remark,customerName,customerMobile);
        repo.orderList.add(order);
        System.out.println("Taking Your Order Please Wait for a while");
        
           System.out.println("Your Order is Ready. Please pay Rs."+amount+".");
           
           Float coffeewaste = blackTeaQuantity*0.0F;
           Float waterwaste = blackTeaQuantity*12.0F;
           Float milkwaste = blackTeaQuantity*0.0F;
           Float sugarwaste = blackTeaQuantity*2.0F;
           Float teawaste = blackTeaQuantity*0.0F;
           
           cont.setCoffee_container(cont.getCoffee_container() - blackTeaQuantity*0);
           cont.setWater_container(cont.getWater_container() - blackTeaQuantity*112);
           cont.setMilk_container(cont.getMilk_container() - blackTeaQuantity*0);
           cont.setSugar_container(cont.getSugar_container() - blackTeaQuantity*17);
           cont.setTea_container(cont.getTea_container() - blackTeaQuantity*3);
           
           waste.setCoffeewaste(waste.getCoffeewaste()+coffeewaste);
           waste.setWaterwaste(waste.getWaterwaste()+waterwaste);
           waste.setMilkwaste(waste.getMilkwaste()+milkwaste);
           waste.setSugarwaste(waste.getSugarwaste()+sugarwaste);
           waste.setTeawaste(waste.getTeawaste()+teawaste);
           
           
       }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Refill The Container.
     * Also It will Keep Record that How Many Times Counter is Re-filled.
     */
    Integer counter =0;
    private void onRefillContainer() {
        cont.setCoffee_container(2000.0F);
       cont.setTea_container(2000.0F);
       cont.setSugar_container(8000.0F);
       cont.setWater_container(15000.0F);
       cont.setMilk_container(1000.0F);
       
       
       counter = counter + 1;
        System.out.println("Container Refilled Successful");
        System.out.println("Container Refilled "+counter+" Times.");
    }
    
    /**
     * This Method will Show the Individual Sales List of each Order.
     * All The Details can be viewed of every order.
     */
    private void onCheckTotalSale() {
      
        System.out.println("Total Sales Report ");
        List<Order> orderList=repo.orderList;
        for(int i=0;i<repo.orderList.size();i++){
            Order o = orderList.get(i);
            System.out.println((i+1)+". Customer Name:"+o.getCustomerName()+
                    ", Date:"+o.getDate()+", Product:"+o.getProductName()+
                    ", Quantity:"+o.getQuantity()+", Amount:"+o.getAmount()+
                    ", Remark:"+o.getRemark()+", Mobile:"+o.getCustomerMobileNo()+
                    ", Order Id:"+o.getOrderId());
        }
    }        
    
    /**
     * This Method Shows the Quantity Available of The Container used to Prepare Drinks.
     */
    private void onContainerStatus() {
        System.out.println("Container Status:");
        System.out.println("");
        System.out.println("Coffee Container = "+cont.getCoffee_container()+" Grams");
        System.out.println("Tea Container = "+cont.getTea_container()+" Grams");
        System.out.println("Sugar Container = "+cont.getSugar_container()+" Grams");
        System.out.println("Milk Container = "+cont.getMilk_container()+" ml");
        System.out.println("Water Container = "+cont.getWater_container()+" ml");
    }
    
    /**
     * This Method will Reset The Container.i.e It will Set Default Values to the Container.
     */
    private void onResetContainer() {
        
       cont.setCoffee_container(2000.0F);
       cont.setTea_container(2000.0F);
       cont.setSugar_container(8000.0F);
       cont.setWater_container(15000.0F);
       cont.setMilk_container(1000.0F);
       
        System.out.println("Container Reset Successful");
       
    }
    
    /**
     * This Method will Show How Much Raw Material is Wasted while Preparing the orders for the customer.
     */
    private void onShowWaste() {
        System.out.println("Waste Report :");
        System.out.println("");
        System.out.println("Coffee Waste = "+waste.getCoffeewaste()+"gms");
        System.out.println("Tea Waste = "+waste.getTeawaste()+"gms");
        System.out.println("Sugar Waste = "+waste.getSugarwaste()+"gms");
        System.out.println("Water Waste = "+waste.getWaterwaste()+"ml");
        System.out.println("Milk Waste = "+waste.getMilkwaste()+"ml");
    }
 
    /**
     * This Method will Show the Monthly Total of the Sales.
     */
    private void onShowMonthlyOrderList() {
        System.out.println("Monthly Sales Report ");
       
       Map<String,Float> resultMap = reportService.calculateMonthlyTotal();
       Set<String> keys=resultMap.keySet();
       for(String yearMonth : keys){
           //2016,02
           String[] arr = yearMonth.split(",");
           String year = arr[0];
           Integer monthNo = new Integer(arr[1]);
           String monthName = DateUtil.getMonthName(monthNo);
           
           System.out.println(year+" ,"+monthName+":"+resultMap.get(yearMonth));
       }
        
    }
    
    /**
     * This Method will Show the Product Wise Total Sales.
     */
    private void onProductWiseSales() {
        System.out.println("Drink Wise Sales Report ");     
        Map<String,Float> resultMap = reportService.calculateProductTotal();
        Set<String> order = resultMap.keySet();
        Float netTotal = 0.0F;
        for(String productName : order){
            Float productWiseTotal = resultMap.get(productName);
            netTotal=netTotal+productWiseTotal;
            System.out.println(productName+" : "+productWiseTotal);
        }
        System.out.println("-------------------------------");
        System.out.println("Net Total : "+netTotal);
    }
    
     /**
     * This Method will Exit the TCVM Service.
     */
    private void onExit() {
        System.out.println("Thank You For Using TCVM Service. ");
        System.exit(0);
    }

}
