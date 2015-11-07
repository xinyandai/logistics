package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;


public class OfficeLoadingService_Driver {
	public void drive(OfficeLoadingBLService officeLoadingService){
		OfficeLoadingListVO d=new OfficeLoadingListVO("loadingDate", "officeId",
				"trucksId", "arrival", "carId", "supervision",
				"escort",  "shippingId",  "price");
		boolean result=officeLoadingService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
