package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;


public class TranCenterArrivalService_Driver {
	public void drive(TranCenterLoadingBLService tranCenterArrivalService){
		boolean result=tranCenterArrivalService.creat("loadingDate", "transportListId",
				"arrival",  "carId",  "supervision", "escort",
				"shippingId", "price");
		if(result)
			System.out.println("creat suuccessfully!");
	}
	
}
