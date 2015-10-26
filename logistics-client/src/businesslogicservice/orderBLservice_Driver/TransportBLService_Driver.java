package businesslogicservice.orderBLservice_Driver;

import vo.TransportListVO;
import businesslogicservice.orderBLservice.TransportBLService;

public class TransportBLService_Driver {
	public void drive(TransportBLService transportBLService){
		TransportListVO d=new TransportListVO("car", "loadingDate","transId",
				"carId", "origin",  "arrival", "counterId",
				"supervision", "shippingId","price");
		boolean result=transportBLService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
