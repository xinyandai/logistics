package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterArrivalService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterArrivalBLService;
import org.module.client.vo.TranCenterArrivalListVO;
import org.module.common.po.State;

public class TranCenterArrivalController implements TranCenterArrivalBLService {

	private TranCenterArrivalService arrival;
//	private LogisticsService logistics;
	public TranCenterArrivalController() {

		this.arrival = new TranCenterArrival();
//		this.logistics = new Logistics();
	}

	public TranCenterArrivalController(TranCenterArrivalService arrival ) {
		super();
		this.arrival = arrival;
//		this.logistics = logistics;
	}

	public boolean creat(String transId, String date,
			String transportListId, String origin, String stateOfGoods) {
		return this.arrival.creat(new TranCenterArrivalListVO(transId,date,transportListId,origin,stateOfGoods,State.SUBMITTED));
	}

	public ArrayList<TranCenterArrivalListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return this.arrival.getAll(s);
	}

	

}
