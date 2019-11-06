
package com.cricfann;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *This class Contains Static Methods to Handle Date.
 * @author Devesh
 */
public class DateUtil {
    
    
    public static final String[] MONTHS = {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
    /**
     * This method converts String-Date into Date Object.
     * @param dateAsString string formatted date(ex.11/03/2017 : DD/mm/YYYY).
     * @return returns a Date Object for inpute date string.
     */
    public static Date stringToDate(String dateAsString){
       try {  
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
            return df.parse(dateAsString);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    /**
     * This method converts Date Object to String.
     * @param date Date object to be converted to String
     * @return String date in DD/MM/YYYY format.
     */
     public static String dateToString(Date date){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }
    /**
     * The method returns Year and month from Given Date in Format.:
     * EX 2016,02 ; 2016,03 so on...
     * @param date year and month will be extracted from this date.
     * @return return year and month for input date.
     */
    public static String getYearAndMonth(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy,MM"); //EX 2016,02
        return df.format(date);
    }
    /**
     * Returns year for Input date.
     * @param date
     * @return 
     */
    public static Integer getYear(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy"); //EX 2016,02
        return new Integer(df.format(date));
    }
    /**
     * The method returns month name for given month number.
     * 01:Jan , 02:Feb ......,12:Dec.
     * @param monthNo month Number between 1 and 12.
     * @return returns month name for input month no.
     */
    public static String getMonthName(Integer monthNo){
        return MONTHS[monthNo-1];
    }
}
