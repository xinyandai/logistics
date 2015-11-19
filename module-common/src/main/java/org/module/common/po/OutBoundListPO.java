package org.module.common.po;

public class OutBoundListPO {
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
