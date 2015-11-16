package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;


public class OfficeLoadingService_Driver {
	public void drive(OfficeLoadingBLService officeLoadingService){
		boolean result=officeLoadingService.creat("loadingDate", "officeId",
				"trucksId", "arrival", "carId", "supervision",
				"escort",  "shippingId",  "price");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
