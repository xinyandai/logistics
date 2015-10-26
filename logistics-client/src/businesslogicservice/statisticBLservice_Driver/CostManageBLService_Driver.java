package businesslogicservice.statisticBLservice_Driver;

import vo.CostListVO;
import businesslogicservice.statisticBLservice.CostManageBLService;

public class CostManageBLService_Driver {
	public void drive(CostManageBLService costManageBLService){
		CostListVO d=new CostListVO( "date", "money", "people", "accout",
				"entry", "note");
		boolean creat=costManageBLService.creatCostList(d);
		if(creat)
			System.out.println("creat successfully!");
	}
}
