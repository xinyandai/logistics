package org.module.client.BL.Ticket;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.vo.OutBoundListVO;

public class OutBoundMock implements OutBoundService{

	public boolean createTicket(OutBoundListVO out) {
		// TODO Auto-generated method stub
		return out.getTansportListId().equals( "10086" );
	}

	public boolean update(OutBoundListVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<OutBoundListVO> getAll(long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

}
