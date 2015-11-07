package org.module.client.businesslogicservice.ticketBLservice_Driver;

import org.module.client.businesslogicservice.ticketBLservice.CollectionBLService;
import org.module.client.vo.ReceiptListVO;


public class CollectionBLService_Driver {
	public void drive(CollectionBLService collectionBLService){
		ReceiptListVO d=new ReceiptListVO( "date", "money", "courier",
				"orderId");
		boolean creat=collectionBLService.createTicket(d);
		boolean modify=collectionBLService.modifyTicket(d);
		if(creat)
			System.out.println("creat successfully!");
		if(modify)
			System.out.println("modify successfully!");
	}
}
