package org.module.common.po;

import java.io.Serializable;

public class OutBoundListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1714584997642889925L;
	/**
	 * 快递编号
	 */
	private String id;
	/**
	 * 出库日期
	 */
	private String date;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 装运形式
	 */
	private String typeOfLoading;
	/**
	 * 中转单编号或者货运编号
	 */
	private String tansportListId;
//	private String carId;

	/**
	 * 单据状态
	 */
	private State state;

	
	
	public OutBoundListPO(String id, String date, String destination,
		String typeOfLoading, String tansportListId, String state) {
	super();
	this.id = id;
	this.date = date;
	this.destination = destination;
	this.typeOfLoading = typeOfLoading;
	this.tansportListId = tansportListId;
	this.state = State.getInstance(state);
}
	private String spt = ":%:%:";
	
	@Override
	public String toString(){
		return this.id + this.spt+
				this.date + this.spt+
				this.destination + this.spt+
				this.typeOfLoading + this.spt+
				this.tansportListId + this.spt+
				this.state.toString();
	}
	
	public OutBoundListPO(String string) {
		String[] s = string.split(spt);
		this.id = s[0];
		this.date = s[1];
		this.destination = s[2];
		this.typeOfLoading = s[3];
		this.tansportListId = s[4];
		this.state = State.getInstance(s[5]);
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getTypeOfLoading() {
		return typeOfLoading;
	}

	public String getTansportListId() {
		return tansportListId;
	}

	public State getState() {
		return state;
	}
	
	

	

}
