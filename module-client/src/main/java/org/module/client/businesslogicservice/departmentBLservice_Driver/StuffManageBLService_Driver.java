package org.module.client.businesslogicservice.departmentBLservice_Driver;

import org.module.client.businesslogicservice.departmentBLservice.StuffManageBLService;
import org.module.client.vo.StuffVO;


public class StuffManageBLService_Driver {
	public void drive(StuffManageBLService stuffManageBLService){
		StuffVO d=new StuffVO("name", "age", "category", "identity");
		//StuffVO old=new StuffVO("name", "age", "category", "identity");
		boolean add=stuffManageBLService.add(d);
		boolean delete=stuffManageBLService.delete(d);
		boolean modify=stuffManageBLService.modify(d);
		if(add)
			System.out.println("add successfully!\n");
		if(delete)
			System.out.println("delete successfully!\n");		
		if(modify)
			System.out.println("modify successfully!\n");
	}
	
}
