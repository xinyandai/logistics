package org.module.client.businesslogicservice.departmentBLservice_Driver;

import org.module.client.businesslogicservice.departmentBLservice.DepartmentManageBLService;
import org.module.client.vo.DepartmentVO;


public class DepartmentManageBLService_Driver {
	public void drive(DepartmentManageBLService departmentManageBLService){
		
		//DepartmentVO old=new DepartmentVO("name","category","location");
		boolean add=departmentManageBLService.add("name","category","location", "025000");
		boolean delete=departmentManageBLService.delete("025000");
		boolean modify=departmentManageBLService.modify("name","category","location", "025000" );
		if(add)
			System.out.println("add successfully!\n");
		if(delete)
			System.out.println("delete successfully!\n");		
		if(modify)
			System.out.println("modify successfully!\n");
	}	
}
