package org.module.common.po;

import java.io.Serializable;


public class ReceivingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6195996055437305081L;
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
	
	final private String spt = ":%:%:";
	public ReceivingListPO(String string) {
		String[] s = string.split(spt);
		this.date = s[0];
		this.location =s[1];
		this.origin = s[2];
		this.estination  = s[3];
		this.orderId = s[4];
		this.state = State.getInstance(s[5]);
	}
	@Override
	public String toString(){
		return this.date +this.spt +
		this.location  +this.spt +
		this.origin  +this.spt +
		this.estination  +this.spt +
		this.orderId  +this.spt +
		this.state.toString() ;
	}
	
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
