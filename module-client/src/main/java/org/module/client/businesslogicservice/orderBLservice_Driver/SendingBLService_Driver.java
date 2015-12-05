package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.SendingBLService;


public class SendingBLService_Driver {
	public void drive(SendingBLService sendingBLService){
		boolean result=sendingBLService.creat("date",  "shippingId", "sendMember");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
