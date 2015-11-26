package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;


public class OfficeArrivalBLService_Driver {
	public void drive(OfficeArrivalBLService officeArrivalBLService){
		boolean result=officeArrivalBLService.creat("id","date", "transportListId",
				"origin",  "state","SUBMITTED");
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
