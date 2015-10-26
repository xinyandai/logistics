package businesslogicservice.statisticBLservice_Driver;

import businesslogicservice.statisticBLservice.IncomeManageBLService;

public class IncomeManageBLService_Driver {
	public void drive(IncomeManageBLService incomeManageBLService){
		incomeManageBLService.showIncomeList(10, 20);
	}
}
