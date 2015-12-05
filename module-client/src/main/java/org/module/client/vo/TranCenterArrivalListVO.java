package org.module.client.vo;

import org.module.common.po.State;
import org.module.common.po.TranCenterArrivalListPO;

/**
 * 当营业厅送达货物到中转中心之后业务员生成中转中心到达单。
 * 中转中心到达单前缀：
 * 中转中心编号（025城市编码+0中转中心）、
 * 到达日期、
 * 中转单编号（若是由营业厅运送过来直接填写装车单）、
 * 出发地、
 * 货物到达状态（损坏、完整、丢失））
 * @author 
 *
 */

public class TranCenterArrivalListVO  extends AbstractVO{

	private String transId;
	private String date;
	private String transportListId;
	private String origin;
	private String stateOfGoods;
	private State state;
	
	public TranCenterArrivalListVO(String transId, String date,
			String transportListId, String origin, String stateOfGoods,State state) {
		super();
		this.transId = transId;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = state;
	}
	public TranCenterArrivalListVO(TranCenterArrivalListPO officeArrivalListPO) {
		this(officeArrivalListPO.getTransId(),
				officeArrivalListPO.getDate(),
				officeArrivalListPO.getTransportListId(),
				officeArrivalListPO.getOrigin(),
				officeArrivalListPO.getStateOfGoods(),
				officeArrivalListPO.getState()); 
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
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
	public TranCenterArrivalListPO toPO(State pass) {
		
		return new TranCenterArrivalListPO(
				getTransId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
				getStateOfGoods(),
				pass); 
	}
	
	public String[] toArray(){
		String[] s = {getTransId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
				getStateOfGoods()};
		return s;
	}
	
	@Override
	public String get(int i) {
		// TODO Auto-generated method stub
		return this.toArray()[i];
	}
	@Override
	public String[] names() {
		String[] s = {
				"中转中心","到达日期","中转单","出发地","货物到达状态"
		};
	    return s;
	}

}
