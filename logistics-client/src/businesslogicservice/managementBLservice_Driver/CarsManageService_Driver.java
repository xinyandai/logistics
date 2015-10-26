package businesslogicservice.managementBLservice_Driver;

import vo.CarVO;
import businesslogicservice.managementBLservice.CarsManageService;

public class CarsManageService_Driver {
	public void drive(CarsManageService carsManageService){
		CarVO d=new CarVO("id","license","time");
		boolean add=carsManageService.add(d);
		boolean modify=carsManageService.modify( d);
		if(add)
			System.out.println("add successfully!\n");	
		if(modify)
			System.out.println("modify successfully!\n");
	}
}
