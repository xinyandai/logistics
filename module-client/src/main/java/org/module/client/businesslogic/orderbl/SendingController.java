package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.SendingService;
import org.module.client.businesslogicservice.orderBLservice.SendingBLService;
import org.module.client.vo.SendingListVO;

public class SendingController implements SendingBLService {

	private SendingService sending;
//	private LogisticsService logistics;

	public SendingController() {

		this.sending = new Sending();
//		this.logistics = new Logistics();
	}

	public SendingController(SendingService sending ) {
		super();
		this.sending = sending;
//		this.logistics = logistics;
	}

	public boolean creat(String date, String shippingId, String sendMember) {
		return this.sending.creat(new SendingListVO( date,  shippingId,  sendMember));
	}

	public ArrayList<SendingListVO> getAll() {
		// TODO Auto-generated method stub
		return this.sending.getAll();
	}

}
