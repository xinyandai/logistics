package org.module.client.businesslogicservice.managementBLservice_Driver;

import org.module.client.businesslogicservice.managementBLservice.CarsManageBLService;
import org.module.client.vo.CarVO;


public class CarsManageService_Driver {
	public void drive(CarsManageBLService carsManageService){
		CarVO d=new CarVO("id","license","time");
		boolean add=carsManageService.add("id","license","time");
		boolean modify=carsManageService.modify("id","license","time");
		if(add)
			System.out.println("add successfully!\n");	
		if(modify)
			System.out.println("modify successfully!\n");
	}
}
