package org.module.client.businesslogicservice.orderBLservice_Driver;

import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.MailingListVO;


public class MailingBLService_Driver {
	public void drive(MailingBLService mailingBLService){
		MailingListVO d=new MailingListVO("senderName",  "senderCompany",
				 "senderMobile",  "senderPhone",  "senderCity",
				 "senderPosition",  "receiveName",  "receiveCompany",
				 "receiveMobile",  "receivePhone",  "receiveCity",
				 "receivePosition",  "nameOfGood",  "counts",
				 "weight",  "volume",  "costOfDecoration","type",
				 "id");
		boolean result=mailingBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
