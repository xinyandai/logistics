package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogic.logisticsbl.Logistics;
import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceiveListVO;

public class ReceiveController implements ReceiveBLService {
	private ReceiveService receive;
	private LogisticsService logistics;
	public ReceiveController() {
         this.receive = new Receive();
         this.logistics = new Logistics();
	}

	public ReceiveController(ReceiveService receive,LogisticsService logistics) {
		super();
		this.receive = receive;
		this.logistics = logistics;
	}

	public boolean creat(String date, String location, String origin,
			String estination, String orderId) {
		
		return this.receive.creat(new ReceiveListVO( date,  location,  origin,
			 estination,  orderId));
	}

	public ArrayList<ReceiveListVO> getAll() {
		// TODO Auto-generated method stub
		return this.receive.getAll();
	}

}
