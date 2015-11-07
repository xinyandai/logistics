package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;


public class TranCenterLoadingService_Driver {
	public void drive(TranCenterLoadingBLService tranCenterLoadingService){
		TranCenterLoadingListVO d=new TranCenterLoadingListVO( "loadingDate", "transportListId",
				"arrival", "carId", "supervision","escort",
				"shippingId", "price");
		boolean result=tranCenterLoadingService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
