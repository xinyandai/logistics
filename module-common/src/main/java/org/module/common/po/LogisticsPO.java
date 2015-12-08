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
	private String[] historyLocation;
	private String[] historyTime;
	private boolean isCompleted;

	
	
	
	
	public LogisticsPO(String orderId, String origin, String estination,
			String location, String[] historyLocation, String[] historyTime,
			boolean isCompleted) {
		super();
		this.orderId = orderId;
		this.origin = origin;
		this.estination = estination;
		this.location = location;
		this.historyLocation = historyLocation;
		this.historyTime = historyTime;
		this.isCompleted = isCompleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String[] getHistoryLocation() {
		return historyLocation;
	}

	public String[] getHistoryTime() {
		return historyTime;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String getSpt() {
		return spt;
	}

	public String getInlinespt() {
		return inlinespt;
	}

	final private String spt = ":%:%:";
	final private String inlinespt = "&&&&&&&";
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
		
		this.historyTime = s[4].split(inlinespt);
		this.historyLocation = s[5].split(inlinespt);
		this.isCompleted = s[6].equals("true");
		
	}

	@Override
	public String toString(){
		return this.orderId + this.spt +
		this.origin + this.spt +
		this.estination + this.spt +
		this.location + this.spt +
		
		this.getArrayToString(this.historyTime) + this.spt +
		this.getArrayToString(this.historyLocation)+ this.spt +
		this.isCompleted;
	}
	

}
