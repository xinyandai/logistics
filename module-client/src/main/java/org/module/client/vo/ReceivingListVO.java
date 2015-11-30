package org.module.client.vo;

import org.module.common.po.State;

public class ReceivingListVO {

	private String date;
	/***
	 * 收件人
	 */
	private String receiver;
	private String orderId;
	private State  state;
	
	public ReceivingListVO(String date, String receiver, String orderId,
			State state) {
		super();
		this.date = date;
		this.receiver = receiver;
		this.orderId = orderId;
		this.state = state;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
		
		

}
