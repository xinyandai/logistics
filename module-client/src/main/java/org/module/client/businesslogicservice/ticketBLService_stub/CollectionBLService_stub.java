package org.module.client.businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.CollectionBLService;
import org.module.client.vo.ReceiptVO;
import org.module.common.po.ReceiptPO;


public class CollectionBLService_stub implements CollectionBLService{
	ReceiptPO rlpo;
	public boolean createTicket(ReceiptVO t) {
		// TODO �Զ����ɵķ������
		System.out.println("createTicket");
		return false;
	}

	public boolean modifyTicket(ReceiptVO newOne) {
		// TODO �Զ����ɵķ������
		System.out.println("modifyTicket");
		return false;
	}

	public ArrayList<ReceiptVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO �Զ����ɵķ������
		System.out.println("findTicket");
		return null;
	}

	public boolean clear() {
		// TODO �Զ����ɵķ������
		System.out.println("clear Ticket");
		return false;
	}

}
