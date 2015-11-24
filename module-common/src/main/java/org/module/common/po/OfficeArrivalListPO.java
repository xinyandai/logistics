package org.module.common.po;

import java.io.Serializable;

public class OfficeArrivalListPO implements Serializable{
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
	
	final private String spt = ":%:%:";
	public OfficeArrivalListPO(String string) {
		String[] s = string.split(spt);
		this.officeid = s[0];
		this.date = s[1];
		this.transportListId = s[2];
		this.origin = s[3];
		this.stateOfGoods= s[4];
		this.state= State.getInstance(s[5]);
	}
	@Override
	public String toString(){
		return 
				this.officeid + this.spt +
		this.date +this.spt+
		this.transportListId + this.spt +
		this.origin + this.spt +
		this.stateOfGoods + this.spt +
		this.state.toString();
	}
	
	public OfficeArrivalListPO(String officeid, String date,
			String transportListId, String origin, String stateOfGoods,
			String state) {
		super();
		this.officeid = officeid;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = State.getInstance(state);
	}
	public OfficeArrivalListPO(String[] a){
		this(a[0],a[1],a[2],a[3],a[4],a[5]);
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
	
	
}
