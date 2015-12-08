package org.module.client.businesslogicservice.ticketBLService_stub;


import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.OutBoundListVO;

public class OutBoundBLService_stub implements OutBoundBLService{

	public boolean createTicket(String id, String date, String destination,
			String car, String tansportListId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createTicket(OutBoundListVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<OutBoundListVO> getAll(long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(OutBoundListVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
