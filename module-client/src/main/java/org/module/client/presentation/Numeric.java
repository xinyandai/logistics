package org.module.client.presentation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numeric {
	/**
	 * 判断是否是纯数字
	 * @param str 
	 * @return
	 */
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 
	

	
	
		
		private static boolean isMatch(String regex, String orginal){
			if (orginal == null || orginal.trim().equals("")) {
	            return false;
	        }
			Pattern pattern = Pattern.compile(regex);
			Matcher isNum = pattern.matcher(orginal);
			return isNum.matches();
		}

		public static boolean isPositiveInteger(String orginal) {
			return isMatch("^\\+{0,1}[1-9]\\d*", orginal);
		}

		public static boolean isNegativeInteger(String orginal) {
			return isMatch("^-[1-9]\\d*", orginal);
		}

		public static boolean isWholeNumber(String orginal) {
			return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);
		}
		
		public static boolean isPositiveDecimal(String orginal){
			return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);
		}
		
		public static boolean isNegativeDecimal(String orginal){
			return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);
		}
		
		public static boolean isDecimal(String orginal){
			return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
		}
		
		public static boolean isRealNumber(String orginal){
			return isWholeNumber(orginal) || isDecimal(orginal);
		}

	

}
