package org.module.client.BL.Ticket;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.vo.GoDownEntryVO;

public class GoDownEntryMock implements GoDownEntryService{

	public boolean createTicket(GoDownEntryVO go) {
		// TODO Auto-generated method stub
		return go.getQu()=="110";
	}

}
