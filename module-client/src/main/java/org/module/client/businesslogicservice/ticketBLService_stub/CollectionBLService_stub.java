package org.module.client.businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.CollectionBLService;
import org.module.client.vo.ReceiptListVO;
import org.module.common.po.ReceiptListPO;


public class CollectionBLService_stub implements CollectionBLService{
	ReceiptListPO rlpo;
	public boolean createTicket(ReceiptListVO t) {
		// TODO �Զ����ɵķ������
		System.out.println("createTicket");
		return false;
	}

	public boolean modifyTicket(ReceiptListVO newOne) {
		// TODO �Զ����ɵķ������
		System.out.println("modifyTicket");
		return false;
	}

	public ArrayList<ReceiptListVO> findTicketByTime(long timeStart,
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
