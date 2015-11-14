package org.module.client.businesslogicservice.statisticBLservice_Driver;

import java.util.Calendar;
import java.util.Date;

import org.module.client.businesslogicservice.statisticBLservice.CostAndIncomeBLService;


public class CostAndIncomeBLService_Driver {
	public void drive(CostAndIncomeBLService costAndIncomeBLService){
		Calendar start = Calendar.getInstance();
		start.set(2014, 11, 29);
		
		Date date = new Date();
		
		double cost=costAndIncomeBLService.getCost(start.getTimeInMillis(),date.getTime());
		double income=costAndIncomeBLService.getIncome(start.getTimeInMillis(),date.getTime());
		System.out.println("The cost is"+cost);
		System.out.println("The income is"+income);
	}
}
