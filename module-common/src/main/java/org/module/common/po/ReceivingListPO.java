package org.module.common.po;

import java.io.Serializable;


public class ReceivingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6195996055437305081L;
	//收件单
	private String date;
	/***
	 * 收件人
	 */
	private String receiver;
	private String orderId;
	private State  state;
	
	final private String spt = ":%:%:";
	public ReceivingListPO(String string) {
		String[] s = string.split(spt);
		this.date = s[0];
		this.receiver =s[1];
		this.orderId = s[2];
		this.state = State.getInstance(s[3]);
	}
	@Override
	public String toString(){
		return this.date +this.spt +
		this.receiver  +this.spt +
		this.orderId  +this.spt +
		this.state.toString() ;
	}
	
	public ReceivingListPO(String date, String receiver, 
			String orderId, State state) {
		super();
		this.date = date;
		this.receiver = receiver;
		this.orderId = orderId;
		this.state = state;
	}
	
	
	public String getDate() {
		return date;
	}
	public String getReceiver() {
		return receiver;
	}

	
	public String getOrderId() {
		return orderId;
	}
	public State getState() {
		return state;
	}

}
