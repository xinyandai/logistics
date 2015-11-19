package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceivingListVO;

public class ReceivingController implements ReceiveBLService {
	private ReceiveService receive;
//	private LogisticsService logistics;
	public ReceivingController() {
         this.receive = new Receiving();
//         this.logistics = new Logistics();
	}

	public ReceivingController(ReceiveService receive,LogisticsService logistics) {
		super();
		this.receive = receive;
//		this.logistics = logistics;
	}

	public boolean creat(String date, String location, String origin,
			String estination, String orderId) {
		
		return this.receive.creat(new ReceivingListVO( date,  location,  origin,
			 estination,  orderId));
	}

	public ArrayList<ReceivingListVO> getAll() {
		// TODO Auto-generated method stub
		return this.receive.getAll();
	}

}
