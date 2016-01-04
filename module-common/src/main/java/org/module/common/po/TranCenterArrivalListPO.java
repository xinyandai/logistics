package org.module.common.po;

import java.io.Serializable;

public class TranCenterArrivalListPO extends AbstractPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2045332226968777577L;
	private String transId;
	private String date;
	private String transportListId;
	private String origin;
	/**
	 * 货物到达状态
	 */
	private String stateOfGoods;
	/**
	 * 单据状态
	 */
	private State state;
	private String writer;
	
	public TranCenterArrivalListPO(String transId, String date,
			String transportListId, String origin, String stateOfGoods,
			State state,String w) {
		super();
		this.transId = transId;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = state;
		this.writer = w;
	}
	
	
	final private String spt = ":%:%:";
	public TranCenterArrivalListPO(String string) {
		String[] s = string.split(spt);
		this.transId = s[0];
		this.date = s[1];
		this.transportListId = s[2];
		this.origin = s[3];
		this.stateOfGoods = s[4];
		this.state = State.getInstance(s[5]);
		this.writer = s[5];
	}
	@Override
	public String toString(){
		return this.transId + this.spt +
		this.date+ this.spt +
		this.transportListId + this.spt +
		this.origin + this.spt +
		this.stateOfGoods + this.spt +
		this.state.toString()+this.spt + this.writer;
	}
	
	@Override
	public String getBelongsToPersonOrDepartment() {
		// TODO Auto-generated method stub
		return this.writer;
	}
	public String getTransId() {
		return transId;
	}
	public String getDate() {
		return date;
	}
	public String getTransportListId() {
		return transportListId;
	}
	public String getOrigin() {
		return origin;
	}
	public String getStateOfGoods() {
		return stateOfGoods;
	}
	public State getState() {
		return state;
	}
	public String getWriter() {
		return this.writer;
	}
	@Override
	public String getNniqueID() {
		// TODO Auto-generated method stub
		return this.getTransportListId();
	}
	
}
