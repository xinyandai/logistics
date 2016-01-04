package org.module.common.po;

import java.io.Serializable;

public class OfficeArrivalListPO extends AbstractPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4658950376966209983L;
	private String officeid;
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
	
	final private String spt = ":%:%:";
	public OfficeArrivalListPO(String string) {
		String[] s = string.split(spt);
		this.officeid = s[0];
		this.date = s[1];
		this.transportListId = s[2];
		this.origin = s[3];
		this.stateOfGoods= s[4];
		this.state= State.getInstance(s[5]);
		this.writer = s[6];
	}
	@Override
	public String toString(){
		return 
				this.officeid + this.spt +
		this.date +this.spt+
		this.transportListId + this.spt +
		this.origin + this.spt +
		this.stateOfGoods + this.spt +
		this.state.toString() + this.spt + this.writer;
	}
	
	public OfficeArrivalListPO(String officeid, String date,
			String transportListId, String origin, String stateOfGoods,
			State state2,String w) {
		super();
		this.officeid = officeid;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = state2;
		this.writer = w;
	}

	@Override
	public String getBelongsToPersonOrDepartment() {
		// TODO Auto-generated method stub
		return this.writer;
	}
	public String getOfficeid() {
		return officeid;
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
		return this.transportListId;
	}
	
}
