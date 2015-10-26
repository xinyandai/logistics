package businesslogicservice.ticketBLservice_Driver;

import vo.ReceiptListVO;
import businesslogicservice.ticketBLservice.CollectionBLService;

public class CollectionBLService_Driver {
	public void drive(CollectionBLService collectionBLService){
		ReceiptListVO d=new ReceiptListVO( "date", "money", "courier",
				"orderId");
		boolean creat=collectionBLService.creatTicket(d);
		boolean modify=collectionBLService.modifyTicket(d);
		if(creat)
			System.out.println("creat successfully!");
		if(modify)
			System.out.println("modify successfully!");
	}
}
