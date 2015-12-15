package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterArrivalService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterArrivalBLService;
import org.module.client.vo.TranCenterArrivalListVO;

public class TranCenterArrivalController implements TranCenterArrivalBLService {

	private TranCenterArrivalService arrival;
	private ArrayList<TranCenterArrivalListVO> list ;
	
	public TranCenterArrivalController() {

		this.arrival = new TranCenterArrival();
	}

	public TranCenterArrivalController(TranCenterArrivalService arrival ) {
		super();
		this.arrival = arrival;
	}

	public boolean creat(TranCenterArrivalListVO vo) {
		for (TranCenterArrivalListVO tranCenterArrivalListVO : list) {
			if(tranCenterArrivalListVO.getTransportListId().equals(vo.getTransportListId())){
				return false;
			}
		}
		this.list.add(vo);
		return this.arrival.creat(vo);
	}

	public ArrayList<TranCenterArrivalListVO> getAll() {
		this.list = this.arrival.getAll();
		return this.list;
	}

	public boolean update(TranCenterArrivalListVO o) {
		for (TranCenterArrivalListVO tranCenterArrivalListVO : list) {
			if(tranCenterArrivalListVO.getTransportListId().equals(o.getTransportListId())){
				tranCenterArrivalListVO.setDate(o.getDate());
				tranCenterArrivalListVO.setDepartmentId(o.getDepartmentId());
				tranCenterArrivalListVO.setOrigin(o.getOrigin());
				tranCenterArrivalListVO.setStateOfGoods(o.getStateOfGoods());
				tranCenterArrivalListVO.setState(o.getState());
				return this.arrival.update(o);
			}
		}
		return false;
	}

	

}
