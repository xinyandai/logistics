package org.module.client.businesslogicservice.managementBLservice_Driver;

import org.module.client.businesslogicservice.managementBLservice.PriceAndCityManageBLService;


public class PriceAndCityManageService_Driver {
	public void drive(PriceAndCityManageBLService priceAndCityManageService){
//		PriceAndCityVO d=new PriceAndCityVO("A","B","distance","price");
		boolean add=priceAndCityManageService.addCity("nanjing","025");
		boolean set=priceAndCityManageService.setDiretionAndPrice("A","B","distance","price");
		//boolean modify=priceAndCityManageService.setPrice(d,10);
		if(add)
			System.out.println("add successfully!\n");
		if(set)
			System.out.println("delete successfully!\n");		
		/*if(modify)
			System.out.println("modify successfully!\n");*/
	}	
}
