package org.module.client.vo;

public class LogisticsVO {

	private String orderId;
	private String origin;
	private String estination;
	private String location;
	private String[][] historyLocationAndTime;
	private boolean isCompleted;
	public LogisticsVO(String orderId, String origin, String estination,
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
	
	
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public void setOrigin(String origin) {
		this.origin = origin;
	}



	public void setEstination(String estination) {
		this.estination = estination;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public void setHistoryLocationAndTime(String[][] historyLocationAndTime) {
		this.historyLocationAndTime = historyLocationAndTime;
	}



	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
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
