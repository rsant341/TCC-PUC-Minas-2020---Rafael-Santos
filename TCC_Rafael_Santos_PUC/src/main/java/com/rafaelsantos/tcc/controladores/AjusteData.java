package com.rafaelsantos.tcc.controladores;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AjusteData {

    private static final DateFormat 
    			 DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        public static Date createDateFromDateString(String dateString){
        Date date = null;
        if(null != dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    
    }
	
}
