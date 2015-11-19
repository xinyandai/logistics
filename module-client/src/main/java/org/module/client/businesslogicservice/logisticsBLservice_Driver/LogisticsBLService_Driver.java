package org.module.client.businesslogicservice.logisticsBLservice_Driver;

import org.module.client.businesslogicservice.logisticsBLservice.LogisticsBLService;
import org.module.client.vo.LogisticsVO;


public class LogisticsBLService_Driver {
	public void drive(LogisticsBLService logisticsBLService){
		String[][] s = {{"2015/10/1"},{"南京中转中心"}};
		LogisticsVO d=new LogisticsVO("origin", "estination", "location","orderId",s,false);
		boolean setstate=logisticsBLService.setState("id", "state");
		if(setstate)
			System.out.println("set successfully!\n");
	}
}
