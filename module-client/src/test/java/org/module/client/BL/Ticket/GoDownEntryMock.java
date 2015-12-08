package org.module.client.BL.Ticket;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.vo.GoDownEntryVO;

public class GoDownEntryMock implements GoDownEntryService{

	public boolean createTicket(GoDownEntryVO go) {
		// TODO Auto-generated method stub
		return go.getQu()=="110";
	}

	public ArrayList<GoDownEntryVO> getAll(long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(GoDownEntryVO vo) {
		// TODO Auto-generated method stub
		return true;
	}

}
