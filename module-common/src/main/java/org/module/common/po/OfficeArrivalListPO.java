package org.module.common.po;

public class OfficeArrivalListPO {
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
