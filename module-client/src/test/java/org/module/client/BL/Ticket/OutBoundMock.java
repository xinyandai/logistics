package org.module.client.BL.Ticket;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.vo.OutBoundListVO;

public class OutBoundMock implements OutBoundService{

	public boolean createTicket(OutBoundListVO out) {
		// TODO Auto-generated method stub
		return out.getCarId()=="10086";
	}

}
