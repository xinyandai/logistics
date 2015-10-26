package businesslogicservice.managementBLservice_Driver;

import vo.PriceAndCityVO;
import businesslogicservice.managementBLservice.PriceAndCityManageService;

public class PriceAndCityManageService_Driver {
	public void drive(PriceAndCityManageService priceAndCityManageService){
		PriceAndCityVO d=new PriceAndCityVO("distance","price");
		boolean add=priceAndCityManageService.addCity("nanjing");
		boolean delete=priceAndCityManageService.setDiretion(d,10);
		boolean modify=priceAndCityManageService.setPrice(d,10);
		if(add)
			System.out.println("add successfully!\n");
		if(delete)
			System.out.println("delete successfully!\n");		
		if(modify)
			System.out.println("modify successfully!\n");
	}	
}
