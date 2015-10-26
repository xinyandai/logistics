package businesslogicservice.orderBLservice_Driver;

import vo.MailingListVO;
import businesslogicservice.orderBLservice.MailingBLService;

public class MailingBLService_Driver {
	public void drive(MailingBLService mailingBLService){
		MailingListVO d=new MailingListVO("sendername", "senderhome","sendercompany","senderphone", "sendermobile",
				"recipientname", "recipienthome","recipientcompany", "recipientphone",
				"recipientmobile", "number", "weight","volume", "goodsname", "way", "packing","price", "orderId");
		boolean result=mailingBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
		
	}
}
