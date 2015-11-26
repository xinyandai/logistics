package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.TransportBLService;


public class TransportBLService_Driver {
	public void drive(TransportBLService transportBLService){
		String[] s = { "shippingId"};
		boolean result=transportBLService.creat("car", "loadingDate","transId",
				"carId", "origin",  "arrival", "counterId",
				"supervision", s,"price","SUBMITTED");
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
