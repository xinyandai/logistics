package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeArrivalService;
import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.client.vo.TranCenterArrivalListVO;

public class OfficeArrivalController implements OfficeArrivalBLService{
	private OfficeArrivalService  officeArrival;
	private ArrayList<OfficeArrivalListVO> list ;
	
	public OfficeArrivalController(OfficeArrivalService officeArrival ) {
		super();
		this.officeArrival = officeArrival;
	}

	public OfficeArrivalController() {
		officeArrival = new OfficeArrival();
	}

	public boolean creat(OfficeArrivalListVO o) {
		this.list.add(o);
		return officeArrival.creat(o);
	}

	public ArrayList<OfficeArrivalListVO> getAll() {
		this.list = this.officeArrival.getAll();
		return list;
	}
	
	public boolean update(OfficeArrivalListVO o){
		for (OfficeArrivalListVO officeArrivalListVO : list) {
			if(officeArrivalListVO.getTransportListId().equals(o.getTransportListId())){
				officeArrivalListVO.setDate(o.getDate());
				officeArrivalListVO.setDepartmentId(o.getDepartmentId());
				officeArrivalListVO.setOrigin(o.getOrigin());
				officeArrivalListVO.setStateOfGoods(o.getStateOfGoods());
				officeArrivalListVO.setState(o.getState());
				return this.officeArrival.update(o);
			}
		}
		return false;
	}
}
