package businesslogicservice.logisticsBLservice_Driver;

import vo.LogisticsVO;
import businesslogicservice.logisticsBLservice.LogisticsBLService;

public class LogisticsBLService_Driver {
	public void drive(LogisticsBLService logisticsBLService){
		LogisticsVO d=new LogisticsVO("origin", "estination", "location","orderId");
		boolean setstate=logisticsBLService.setState("id", "state");
		boolean Setstate=logisticsBLService.setState(d);
		if(setstate)
			System.out.println("set successfully!\n");
		if(Setstate)
			System.out.println("Set successfully!\n");
	}
}
