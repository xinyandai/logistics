package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;


public class ReceiveBLService_Driver {
	public void drive(ReceiveBLService receiveBLService){
		boolean result=receiveBLService.creat("date", "location", "origin",
				"estination",  "orderId","SUBMITTED");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
