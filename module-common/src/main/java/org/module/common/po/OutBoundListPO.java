package org.module.common.po;

import java.io.Serializable;

public class OutBoundListPO extends AbstractPO implements Serializable{
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
	 * 中转单编号
	 */
	private String tansportListId;

	/**
	 * 单据状态
	 */
	private State state;

	private String warehouseOfWhichTranCenter;
	
	public OutBoundListPO(String id, String date, String destination,
		String typeOfLoading, String tansportListId,String warehouseOfWhichTranCenter, State state) {
		
	super();
	this.id = id;
	this.date = date;
	this.destination = destination;
	this.typeOfLoading = typeOfLoading;
	this.tansportListId = tansportListId;
	this.warehouseOfWhichTranCenter = warehouseOfWhichTranCenter;
	this.state =state;
}
	final private String spt = ":%:%:";
	
	@Override
	public String toString(){
		return this.id + this.spt+
				this.date + this.spt+
				this.destination + this.spt+
				this.typeOfLoading + this.spt+
				this.tansportListId + this.spt+
				this.warehouseOfWhichTranCenter + this.spt +
				this.state.toString();
	}
	
	public OutBoundListPO(String string) {
		String[] s = string.split(spt);
		this.id = s[0];
		this.date = s[1];
		this.destination = s[2];
		this.typeOfLoading = s[3];
		this.tansportListId = s[4];
		this.warehouseOfWhichTranCenter = s[5];
		this.state = State.getInstance(s[6]);
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

	public String getWarehouseOfWhichTranCenter() {
		return warehouseOfWhichTranCenter;
	}

	@Override
	public String getNniqueID() {
		// TODO Auto-generated method stub
		return this.getId();
	}

	@Override
	public String getBelongsToPersonOrDepartment() {
		// TODO Auto-generated method stub
		return this.getWarehouseOfWhichTranCenter();
	}
	
	

	

}
