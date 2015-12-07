package org.module.client.vo;

import org.module.common.po.State;

public abstract class AbstractArrialListVO extends AbstractVO{
	protected String departmentID;
	protected String date;
	protected String transportListId;
	protected String origin;
	protected String stateOfGoods;
	protected State state;
	
	
	public String getDepartmentId() {
		return departmentID;
	}
	public void setDepartmentId(String transId) {
		this.departmentID = transId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransportListId() {
		return transportListId;
	}
	public void setTransportListId(String transportListId) {
		this.transportListId = transportListId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getStateOfGoods() {
		return stateOfGoods;
	}
	public void setStateOfGoods(String stateOfGoods) {
		this.stateOfGoods = stateOfGoods;
	}
	
	
	public String[] toArray(){
		String[] s = {getDepartmentId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
				getStateOfGoods()};
		return s;
	}
}
