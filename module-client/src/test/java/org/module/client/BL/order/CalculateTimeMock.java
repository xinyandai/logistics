package org.module.client.BL.order;

import org.module.client.businesslogicservice.order.CalculateTimeService;

public class CalculateTimeMock implements CalculateTimeService{

	public int calculateTime(String origin, String target) {
		if(origin.equals("南京")&&target.equals("北京")) return 3;
		return 0;
	}

	

}
