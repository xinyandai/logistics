package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.common.po.State;


public class ReceiveBLService_Driver {
	public void drive(ReceiveBLService receiveBLService){
		boolean result=receiveBLService.creat("date", 
				"estination",  "orderId",State.SUBMITTED);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
