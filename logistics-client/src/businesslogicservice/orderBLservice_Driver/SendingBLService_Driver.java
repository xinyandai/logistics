package businesslogicservice.orderBLservice_Driver;

import vo.SendingListVO;
import businesslogicservice.orderBLservice.SendingBLService;

public class SendingBLService_Driver {
	public void drive(SendingBLService sendingBLService){
		SendingListVO d=new SendingListVO( "date",  "shippingId", "sendMember");
		boolean result=sendingBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
