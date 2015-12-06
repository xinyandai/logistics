package org.module.client.presentation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransferHelper {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String getString(Date date){
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static Date getDate(String str){
		Date date = new Date();
		try {    
	           date = formatter.parse(str);   
		} catch (ParseException e) {    
	           e.printStackTrace();    
		}
		return date;   

	}
}
