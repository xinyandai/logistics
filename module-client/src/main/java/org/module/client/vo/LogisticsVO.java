package org.module.client.vo;

import org.module.common.po.LogisticsPO;

public class LogisticsVO {

	private String orderId;
	private String origin;
	private String estination;
	private String location;
	private String[] historyLocation;
	private String[] historyTime;
	private boolean isCompleted;
	
	
	public void addLocationAndTime(String location,String time){
		String[] newhistoryLocaion = new String[this.historyLocation.length+1];
		String[] newhistoryTime = new String[this.historyTime.length+1];
		int i;
		for ( i = 0; i < historyLocation.length; i++) {
			newhistoryLocaion[i] = this.historyLocation[i];
			newhistoryTime[i] = this.historyTime[i];
		}
		newhistoryLocaion[i] = location;
		newhistoryTime[i] = time;
		this.historyLocation = newhistoryLocaion;
		this.historyTime = newhistoryTime;
	}
	
	
	public LogisticsVO(LogisticsPO po){
		this(po.getOrderId(),
				po.getOrigin(),
				po.getEstination(),
				po.getLocation(),
				po.getHistoryLocation(),
				po.getHistoryTime(),
				po.isCompleted());
	}
	
	public LogisticsPO toPO(){
		return new LogisticsPO(getOrderId(),
			    getOrigin(),
				getEstination(),
				getLocation(),
				getHistoryLocation(),
				getHistoryTime(),
				isCompleted());
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getEstination() {
		return estination;
	}
	public void setEstination(String estination) {
		this.estination = estination;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String[] getHistoryLocation() {
		return historyLocation;
	}
	public void setHistoryLocation(String[] historyLocation) {
		this.historyLocation = historyLocation;
	}
	public String[] getHistoryTime() {
		return historyTime;
	}
	public void setHistoryTime(String[] historyTime) {
		this.historyTime = historyTime;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public LogisticsVO(String orderId, String origin, String estination,
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
	

}
