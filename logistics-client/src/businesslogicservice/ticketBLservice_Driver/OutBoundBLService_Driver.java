package businesslogicservice.ticketBLservice_Driver;

import vo.OutBoundListVO;
import businesslogicservice.ticketBLservice.OutBoundBLService;

public class OutBoundBLService_Driver {
	public void drive(OutBoundBLService outBoundBLService){
		OutBoundListVO d=new OutBoundListVO("courier","date","destination",
				"car","tansportListId", "carId");
		boolean creat=outBoundBLService.creatTicket(d);
		boolean modify=outBoundBLService.modifyTicket(d);
		if(creat)
			System.out.println("creat successfully!");
		if(modify)
			System.out.println("modify successfully!");
		
	}
}
