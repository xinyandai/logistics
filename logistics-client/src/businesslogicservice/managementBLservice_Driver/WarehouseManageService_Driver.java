package businesslogicservice.managementBLservice_Driver;

import java.util.ArrayList;

import vo.GoDownEntryListVO;
import vo.OutBoundListVO;
import vo.WarehouseVO;
import businesslogicservice.managementBLservice.WarehouseManageService;

public class WarehouseManageService_Driver {
	public void drive(WarehouseManageService warehouseManageService){
		OutBoundListVO d=new OutBoundListVO("courier","date","destination",
				"car","tansportListId", "carId");
		GoDownEntryListVO e=new GoDownEntryListVO("courier","date","destination",
				"qu","pai", "jia", "wei");
		ArrayList<WarehouseVO> past=new ArrayList();
		ArrayList<WarehouseVO> now=new ArrayList();
		past=warehouseManageService.getAll();
		
		warehouseManageService.outBound(d);
		now=warehouseManageService.getAll();
		if(now==past){
			System.out.println("outBound successfully!");
		}
		warehouseManageService.goDown(e);
		now=warehouseManageService.getAll();
		if(now==past){
			System.out.println("outBound successfully!");
		}
		
	}
}
