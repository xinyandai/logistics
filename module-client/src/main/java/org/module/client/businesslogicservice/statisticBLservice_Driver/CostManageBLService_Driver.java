package org.module.client.businesslogicservice.statisticBLservice_Driver;

import org.module.client.businesslogicservice.statisticBLservice.CostManageBLService;
import org.module.client.vo.CostListVO;


public class CostManageBLService_Driver {
	public void drive(CostManageBLService costManageBLService){
		CostListVO d=new CostListVO( "date", "money", "people", "accout",
				"entry", "note");
		boolean creat=costManageBLService.creatCostList(d);
		if(creat)
			System.out.println("creat successfully!");
	}
}
