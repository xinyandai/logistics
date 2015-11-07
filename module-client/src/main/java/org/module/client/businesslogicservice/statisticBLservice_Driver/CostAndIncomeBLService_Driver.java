package org.module.client.businesslogicservice.statisticBLservice_Driver;

import org.module.client.businesslogicservice.statisticBLservice.CostAndIncomeBLService;


public class CostAndIncomeBLService_Driver {
	public void drive(CostAndIncomeBLService costAndIncomeBLService){
		double cost=costAndIncomeBLService.getCost();
		double income=costAndIncomeBLService.getIncome();
		System.out.println("The cost is"+cost);
		System.out.println("The income is"+income);
	}
}
