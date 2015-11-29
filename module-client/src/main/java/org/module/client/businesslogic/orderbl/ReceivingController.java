package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceivingListVO;
import org.module.common.po.State;

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

	public boolean creat(String date, String receiver,  String orderId,State state) {
		
		return this.receive.creat(new ReceivingListVO( date,  receiver,
			   orderId,state));
	}

	public ArrayList<ReceivingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return this.receive.getAll(s);
	}

}
