package businesslogicservice.orderBLservice_Driver;

import vo.ReceiveListVO;
import businesslogicservice.orderBLservice.ReceiveBLService;

public class ReceiveBLService_Driver {
	public void drive(ReceiveBLService receiveBLService){
		ReceiveListVO d=new ReceiveListVO("date", "location", "origin",
				"estination",  "orderId");
		boolean result=receiveBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
