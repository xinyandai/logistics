package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceivingListVO;

public class ReceivingController implements ReceiveBLService {
	private ReceiveService receive;
	private ArrayList<ReceivingListVO> list;
	
	public ReceivingController() {
         this.receive = new Receiving();
	}

	public ReceivingController(ReceiveService receive,LogisticsService logistics) {
		super();
		this.receive = receive;
	}

	public boolean creat(ReceivingListVO o) {
		this.list.add(o);
		return this.receive.creat(o);
	}

	public ArrayList<ReceivingListVO> getAll() {
		this.list =  this.receive.getAll();
		return this.list;
	}

	public boolean update(ReceivingListVO o) {
		for (ReceivingListVO receivingListVO : list) {
			if(receivingListVO.getOrderId().equals(o.getOrderId())){
				receivingListVO.setDate(o.getDate());
				receivingListVO.setOrderId(o.getOrderId());
				receivingListVO.setReceiver(o.getReceiver());
				receivingListVO.setState(o.getState());
				return this.receive.update(receivingListVO);
			}
		}
		return false;
	}

}
