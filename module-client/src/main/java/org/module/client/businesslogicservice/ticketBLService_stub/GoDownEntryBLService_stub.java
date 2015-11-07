package org.module.client.businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.vo.GoDownEntryListVO;
import org.module.common.po.GoDownEntryListPO;


public class GoDownEntryBLService_stub implements GoDownEntryBLService{
	GoDownEntryListPO gdepo;
	public boolean createTicket(GoDownEntryListVO t) {
		// TODO �Զ����ɵķ������
		System.out.println("GodownEntry");
		return false;
	}

	public boolean modifyTicket(GoDownEntryListVO newOne) {
		// TODO �Զ����ɵķ������
		System.out.println("GodownEntry");
		return false;
	}

	public ArrayList<GoDownEntryListVO> findTicketByTime(long timeStart,
			long timeEnd) {
		// TODO �Զ����ɵķ������
		System.out.println("GodownEntry");
		return null;
	}

	public boolean clear() {
		// TODO �Զ����ɵķ������
		System.out.println("GodownEntry");
		return false;
	}

}
