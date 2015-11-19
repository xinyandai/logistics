package org.module.client.businesslogicservice.managementBLservice_Driver;

import org.module.client.businesslogicservice.managementBLservice.DriversManageBLService;


public class DriversManageService_Driver {
	public void drive(DriversManageBLService driversManageService){
	//	DriverVO d=new DriverVO("id","name", "birthday","idcard","phone", "gender","date");
		boolean add=driversManageService.add("id","name", "birthday","idcard","phone", "gender","date");
		boolean modify=driversManageService.modify( "id","name", "birthday","idcard","phone", "gender","date");
		if(add)
			System.out.println("add successfully!\n");	
		if(modify)
			System.out.println("modify successfully!\n");
	}
}
