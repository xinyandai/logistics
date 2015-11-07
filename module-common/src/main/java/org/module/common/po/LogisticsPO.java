package org.module.common.po;

public class LogisticsPO {
	private String orderId;
	private String origin;
	private String estination;
	private String location;
	private String[][] historyLocationAndTime;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LogisticsPO(String origin, String estination,
			String location,String orderId, String[][] historyLocationAndTime) {
		super();
		this.orderId = orderId;
		this.origin = origin;
		this.estination = estination;
		this.location = location;
		this.historyLocationAndTime = historyLocationAndTime;
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
	public String[][] getHistoryLocationAndTime() {
		return historyLocationAndTime;
	}
	public void setHistoryLocationAndTime(String[][] historyLocationAndTime) {
		this.historyLocationAndTime = historyLocationAndTime;
	}
	

}
