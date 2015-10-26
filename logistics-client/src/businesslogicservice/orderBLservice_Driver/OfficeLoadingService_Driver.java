package businesslogicservice.orderBLservice_Driver;

import vo.OfficeLoadingListVO;
import businesslogicservice.orderBLservice.OfficeLoadingBLService;

public class OfficeLoadingService_Driver {
	public void drive(OfficeLoadingBLService officeLoadingService){
		OfficeLoadingListVO d=new OfficeLoadingListVO("loadingDate", "officeId",
				"trucksId", "arrival", "carId", "supervision",
				"escort",  "shippingId",  "price");
		boolean result=officeLoadingService.creat(d);
		if(result)
			System.out.println("creat suuccessfully!");
	}
}
