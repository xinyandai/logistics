package org.module.client.BL.order;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;

public class CalculateDriverCostMock implements CalculateDriverCostService {

	public CalculateDriverCostMock() {
		// TODO Auto-generated constructor stub
	}

	public double calculateDriverCost(String origin, String target) {
		if(!origin.equals(target)) return 3;
 		return 0;
	}

}
