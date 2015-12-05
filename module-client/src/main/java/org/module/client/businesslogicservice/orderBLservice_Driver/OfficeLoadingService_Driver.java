package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;


public class OfficeLoadingService_Driver {
	public void drive(OfficeLoadingBLService officeLoadingService){
		String[] s = { "shippingId"};
		boolean result=officeLoadingService.creat("loadingDate", "officeId",
				"trucksId", "arrival", "lcoation","carId", "supervision",
				"escort", s,  "price");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
