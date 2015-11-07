package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;


public class OfficeArrivalBLService_Driver {
	public void drive(OfficeArrivalBLService officeArrivalBLService){
		OfficeArrivalListVO d=new OfficeArrivalListVO("date", "transportListId",
				"origin",  "state");
		boolean result=officeArrivalBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
