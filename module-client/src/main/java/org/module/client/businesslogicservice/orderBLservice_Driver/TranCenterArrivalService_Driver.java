package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;


public class TranCenterArrivalService_Driver {
	public void drive(TranCenterLoadingBLService tranCenterArrivalService){
		TranCenterLoadingListVO d=new TranCenterLoadingListVO("loadingDate", "transportListId",
				"arrival",  "carId",  "supervision", "escort",
				"shippingId", "price");
		boolean result=tranCenterArrivalService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
	
}
