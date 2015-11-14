package org.module.client.businesslogicservice.statisticBLService_stub;

import org.module.client.businesslogicservice.statisticBLservice.CostAndIncomeBLService;


public class CostAndIncomeBLService_stub implements CostAndIncomeBLService{

	public double getCost(double startTime, double endTime) {
		// TODO Auto-generated method stub
		return 100;
	}

	public double getIncome(double startTime, double endTime) {
		// TODO Auto-generated method stub
		return 10;
	}

	

	public double getPureIncome(double startTime, double endTime) {
		
		return this.getIncome(startTime, endTime)-this.getCost(startTime, endTime);
	}

	

}
