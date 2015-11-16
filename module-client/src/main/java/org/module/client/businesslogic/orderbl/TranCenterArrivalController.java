package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogic.logisticsbl.Logistics;
import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.order.TranCenterArrivalService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterArrivalBLService;
import org.module.client.vo.SendingListVO;

public class TranCenterArrivalController implements TranCenterArrivalBLService {

	private TranCenterArrivalService arrival;
	private LogisticsService logistics;
	public TranCenterArrivalController() {

		this.arrival = new TranCenterArrival();
		this.logistics = new Logistics();
	}

	public TranCenterArrivalController(TranCenterArrivalService arrival,LogisticsService logistics) {
		super();
		this.arrival = arrival;
		this.logistics = logistics;
	}

	public boolean creat(String date, String shippingId, String sendMember) {
		return this.arrival.creat(new SendingListVO( date,  shippingId,  sendMember));
	}

	public ArrayList<SendingListVO> getAll() {
		// TODO Auto-generated method stub
		return this.arrival.getAll();
	}

}
