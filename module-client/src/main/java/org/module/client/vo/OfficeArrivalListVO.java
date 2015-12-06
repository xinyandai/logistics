package org.module.client.vo;

import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;

/**
 * 当其它营业厅或中转中心送达货物，首先营业厅业务员生成营业厅到达单。
 * 营业厅到达单前缀为： 
 * 包含货物到达信息（到达日期、中转单编号(如果是由中转中心运送过来的话否则直接填写装车单)、出发地、货物到达状态（损坏、完整、丢失））
 * @author 
 *
 */
public class OfficeArrivalListVO extends AbstractArrialListVO{

	
	public OfficeArrivalListVO(String officeid, String date,
			String transportListId, String origin, String stateOfGoods,State state) {
		this.departmentID = officeid;
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.stateOfGoods = stateOfGoods;
		this.state = state;
	}
	public OfficeArrivalListVO(OfficeArrivalListPO officeArrivalListPO) {
		this(
				officeArrivalListPO.getOfficeid(),
				officeArrivalListPO.getDate(),
				officeArrivalListPO.getTransportListId(),
				officeArrivalListPO.getOrigin(),
		        officeArrivalListPO.getStateOfGoods(),
		        officeArrivalListPO.getState()
		
		);
	}
	
	
	public OfficeArrivalListPO toPO(State state) {
		// TODO Auto-generated method stub
		return new OfficeArrivalListPO(
				getDepartmentId(),
				getDate(),
				getTransportListId(),
				getOrigin(),
		        getStateOfGoods(),
		        state
		        );
	}
	
	
	
	@Override
	public String get(int i) {
		// TODO Auto-generated method stub
		return this.toArray()[i];
	}
	@Override
	public String[] names() {
		String[] s = {
				"营业厅","到达日期","中转单","出发地","货物到达状态"
		};
	    return s;
	}
	//到达日期、中转单编号(如果是由中转中心运送过来的话否则直接填写装车单)、出发地、货物到达状态（损坏、完整、丢失）
}
