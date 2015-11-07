package org.module.client.businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.OutBoundListVO;
import org.module.common.po.OutBoundListPO;

public class OutBoundBLService_stub implements OutBoundBLService{
	OutBoundListPO oblpo;
	public boolean createTicket(OutBoundListVO t) {
		// TODO �Զ����ɵķ������
		System.out.println("OutBound");
		return false;
	}

	public boolean modifyTicket(OutBoundListVO newOne) {
		// TODO �Զ����ɵķ������
		System.out.println("OutBound");
		return false;
	}

	public ArrayList<OutBoundListVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO �Զ����ɵķ������
		System.out.println("OutBound");
		return null;
	}

	public boolean clear() {
		// TODO �Զ����ɵķ������
		System.out.println("OutBound");
		return false;
	}

}
