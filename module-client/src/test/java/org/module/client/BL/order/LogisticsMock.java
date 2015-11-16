package org.module.client.BL.order;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.vo.LogisticsVO;

public class LogisticsMock implements LogisticsService {

	public LogisticsMock() {
		
	}

	public LogisticsVO showState(String id) {
		return null;
	}

	public boolean setState(String id, String state) {
		if(id.length() == 10) return true;
		return false;
	}

	public boolean setState(LogisticsVO o) {
		if(o.getOrderId().length() == 10) return true;
		return false;
	}

}
