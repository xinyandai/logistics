package businesslogicservice.managementBLservice_Driver;

import vo.DriverVO;
import businesslogicservice.managementBLservice.DriversManageService;

public class DriversManageService_Driver {
	public void drive(DriversManageService driversManageService){
		DriverVO d=new DriverVO("id","name", "birthday","idcard","phone", "gender","date");
		boolean add=driversManageService.add(d);
		boolean modify=driversManageService.modify( d);
		if(add)
			System.out.println("add successfully!\n");	
		if(modify)
			System.out.println("modify successfully!\n");
	}
}
