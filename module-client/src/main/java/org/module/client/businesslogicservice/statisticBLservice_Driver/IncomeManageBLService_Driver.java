package org.module.client.businesslogicservice.statisticBLservice_Driver;

import org.module.client.businesslogicservice.statisticBLservice.IncomeManageBLService;


public class IncomeManageBLService_Driver {
	public void drive(IncomeManageBLService incomeManageBLService){
		incomeManageBLService.showIncomeList("全部",10, 20);
	}
}
