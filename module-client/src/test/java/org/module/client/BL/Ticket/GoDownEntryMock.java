package org.module.client.BL.Ticket;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.vo.GoDownEntryListVO;

public class GoDownEntryMock implements GoDownEntryService{

	public boolean createTicket(GoDownEntryListVO go) {
		// TODO Auto-generated method stub
		return go.getQu()=="110";
	}

}
