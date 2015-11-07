package org.module.client.businesslogicservice.managementBLservice_Driver;

import org.module.client.businesslogicservice.managementBLservice.CarsManageService;
import org.module.client.vo.CarVO;


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
