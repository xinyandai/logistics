package org.module.client.businesslogicservice.ticketBLservice_Driver;

import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.OutBoundListVO;

public class OutBoundBLService_Driver {
	public void drive(OutBoundBLService outBoundBLService){
		OutBoundListVO d=new OutBoundListVO("courier","date","destination",
				"car","tansportListId", "carId");
		boolean creat=outBoundBLService.createTicket("courier","date","destination",
				"car","tansportListId", "carId");

		if(creat)
			System.out.println("creat successfully!");
		
	}
}
