package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.SendingService;
import org.module.client.businesslogicservice.orderBLservice.SendingBLService;
import org.module.client.vo.SendingListVO;


public class SendingController implements SendingBLService {

	private SendingService sending;
	private ArrayList<SendingListVO> list;

	public SendingController() {

		this.sending = new Sending();
	}

	public SendingController(SendingService sending ) {
		super();
		this.sending = sending;
	}

	public boolean creat(SendingListVO vo) {
		for (SendingListVO sendingListVO : list) {
			if(sendingListVO.getShippingId().equals(vo.getShippingId())){
				return false;
			}
		}
		this.list.add(vo);
		return this.sending.creat(vo);
	}

	public ArrayList<SendingListVO> getAll() {
		this.list =  this.sending.getAll( );
		return list;
	}

	public boolean update(SendingListVO vo) {
		for (SendingListVO sendingListVO : list) {
			if(sendingListVO.getShippingId().equals(vo.getShippingId())){
				sendingListVO.setDate(vo.getDate());
				sendingListVO.setSendMember(vo.getSendMember());
				sendingListVO.setState(vo.getState());
				return this.sending.update(vo);
			}
		}
		return false;
	}

}
