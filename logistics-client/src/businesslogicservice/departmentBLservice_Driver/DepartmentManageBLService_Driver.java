package businesslogicservice.departmentBLservice_Driver;

import businesslogicservice.departmentBLservice.DepartmentManageBLService;
import vo.DepartmentVO;

public class DepartmentManageBLService_Driver {
	public void drive(DepartmentManageBLService departmentManageBLService){
		DepartmentVO d=new DepartmentVO("name","category","location");
		//DepartmentVO old=new DepartmentVO("name","category","location");
		boolean add=departmentManageBLService.add(d);
		boolean delete=departmentManageBLService.delete(d);
		boolean modify=departmentManageBLService.modify( d);
		if(add)
			System.out.println("add successfully!\n");
		if(delete)
			System.out.println("delete successfully!\n");		
		if(modify)
			System.out.println("modify successfully!\n");
	}	
}
