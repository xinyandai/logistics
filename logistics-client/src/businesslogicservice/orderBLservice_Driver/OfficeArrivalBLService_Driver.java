package businesslogicservice.orderBLservice_Driver;

import vo.OfficeArrivalListVO;
import businesslogicservice.orderBLservice.OfficeArrivalBLService;

public class OfficeArrivalBLService_Driver {
	public void drive(OfficeArrivalBLService officeArrivalBLService){
		OfficeArrivalListVO d=new OfficeArrivalListVO("date", "transportListId",
				"origin",  "state");
		boolean result=officeArrivalBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
