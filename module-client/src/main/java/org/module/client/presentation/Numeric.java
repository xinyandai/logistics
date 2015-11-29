package org.module.client.presentation;

import java.util.regex.Pattern;

public class Numeric {
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 
}
