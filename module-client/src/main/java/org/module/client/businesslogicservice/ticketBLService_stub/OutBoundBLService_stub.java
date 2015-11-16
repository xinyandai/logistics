package org.module.client.businesslogicservice.ticketBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.OutBoundListVO;
import org.module.common.po.OutBoundListPO;

public class OutBoundBLService_stub implements OutBoundBLService{

	public boolean createTicket(String courier, String date,
			String destination, String car, String tansportListId, String carId) {
		// TODO Auto-generated method stub
		System.out.println("OutBound");
		return false;
	}

}
