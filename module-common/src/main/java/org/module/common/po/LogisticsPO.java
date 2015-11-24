package org.module.common.po;

import java.io.Serializable;

public class LogisticsPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4593210891359674130L;
	private String orderId;
	private String origin;
	private String estination;
	private String location;
	private String[][] historyLocationAndTime;
	
	private boolean isCompleted;

	
	
	
	
	public LogisticsPO(String orderId, String origin, String estination,
			String location, String[][] historyLocationAndTime,
			boolean isCompleted) {
		super();
		this.orderId = orderId;
		this.origin = origin;
		this.estination = estination;
		this.location = location;
		this.historyLocationAndTime = historyLocationAndTime;
		this.isCompleted = isCompleted;
	}

	final private String spt = ":%:%:";
	final private String inlinespt = "#*#*#";
	/**
	 * 把订单号数组转化为字符串
	 * @param s
	 * @return
	 */
	private String getArrayToString(String[] s){
		String re = "";
		for (String string : s) {
			re += string + this.inlinespt;
		}
		return re;
	}
	
	public LogisticsPO(String string) {
		String[] s = string.split(spt);
		this.orderId = s[0];
		this.origin = s[1];
		this.estination = s[2];
		this.location = s[3];
		
	}

	public String getOrderId() {
		return orderId;
	}

	public String getOrigin() {
		return origin;
	}

	public String getEstination() {
		return estination;
	}

	public String getLocation() {
		return location;
	}

	public String[][] getHistoryLocationAndTime() {
		return historyLocationAndTime;
	}

	public boolean isCompleted() {
		return isCompleted;
	}
	
	

}
