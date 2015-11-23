package org.module.common.po;


public class ReceivingListPO {
	//收件单
		/*private String date;
		private String location;
		LogisticsPO logistics;*/
	private String date;
	private String location;
	//LogisticsVO logistics;
	private String origin;
	private String estination;
	private String orderId;
	private State  state;
	
	
	
	public ReceivingListPO(String date, String location, String origin,
			String estination, String orderId, String state) {
		super();
		this.date = date;
		this.location = location;
		this.origin = origin;
		this.estination = estination;
		this.orderId = orderId;
		this.state = State.getInstance(state);
	}
	public ReceivingListPO(String[] a){
		this(a[0],a[1],a[2],a[3],a[4],a[5]);
	}
	public String getDate() {
		return date;
	}
	public String getLocation() {
		return location;
	}
	public String getOrigin() {
		return origin;
	}
	public String getEstination() {
		return estination;
	}
	public String getOrderId() {
		return orderId;
	}
	public State getState() {
		return state;
	}

}
