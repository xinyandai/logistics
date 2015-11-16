package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceiveListVO;

public class ReceiveController implements ReceiveBLService {
	private ReceiveService receive;
	public ReceiveController() {
         this.receive = new Receive();
	}

	public ReceiveController(ReceiveService receive) {
		super();
		this.receive = receive;
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
