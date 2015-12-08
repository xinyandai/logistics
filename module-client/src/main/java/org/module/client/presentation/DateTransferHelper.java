package org.module.client.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransferHelper {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat formatterForDay = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getString(Date date){
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static Date getDate(String str){
		Date date = new Date();
		try {    
	           date = formatter.parse(str);   
		} catch (ParseException e) { 
			try {  
				date = formatterForDay.parse(str);     
			}catch (ParseException e1) {    
				return new Date();  
			}
		}
		return date;   

	}
}
