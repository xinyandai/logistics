package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;


public class TranCenterLoadingService_Driver {
	public void drive(TranCenterLoadingBLService tranCenterLoadingService){
		String[] s = { "shippingId"};
		boolean result=tranCenterLoadingService.creat( "loadingDate","","", "transportListId",
				"arrival", "carId", "supervision","escort",
				s, "price","SUBMITTED");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
