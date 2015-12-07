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

public class TranCenterArrivalListVO  extends AbstractArrialListVO{

	
	public TranCenterArrivalListVO(String transId, String date,
			String transportListId, String origin, String stateOfGoods,State state) {
		this.departmentID = transId;
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
	

	public TranCenterArrivalListPO toPO(State pass) {
		
		return new TranCenterArrivalListPO(
				getDepartmentId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
				getStateOfGoods(),
				pass); 
	}
	
	public String[] toArray(){
		String[] s = {getDepartmentId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
				getStateOfGoods()};
		return s;
	}
	@Override
	public String get(int i) {
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
