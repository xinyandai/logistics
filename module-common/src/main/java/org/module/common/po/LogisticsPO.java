package org.module.common.po;

public class LogisticsPO {
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
