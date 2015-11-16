package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;


public class OfficeArrivalBLService_Driver {
	public void drive(OfficeArrivalBLService officeArrivalBLService){
		boolean result=officeArrivalBLService.creat("id","date", "transportListId",
				"origin",  "state");
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
