package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;


public class MailingBLService_Driver {
	public void drive(MailingBLService mailingBLService){
		
		boolean result=mailingBLService.handleMailingList("senderName",  "senderCompany",
				 "senderMobile",  "senderPhone",  "senderCity",
				 "senderPosition",  "receiveName",  "receiveCompany",
				 "receiveMobile",  "receivePhone",  "receiveCity",
				 "receivePosition",  "nameOfGood",  "counts",
				 "weight",  "volume",  "costOfDecoration","type",
				 "id");
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
