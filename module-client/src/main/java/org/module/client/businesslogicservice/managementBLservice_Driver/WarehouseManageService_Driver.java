package org.module.client.businesslogicservice.managementBLservice_Driver;

import java.util.ArrayList;

import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.GoDownEntryListVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;


public class WarehouseManageService_Driver {
	public void drive(WarehouseManageBLService warehouseManageService){
		OutBoundListVO d=new OutBoundListVO("courier","date","destination",
				"car","tansportListId", "carId");
		GoDownEntryListVO e=new GoDownEntryListVO("courier","date","destination",
				"qu","pai", "jia", "wei");
		ArrayList<WarehouseVO> past=new ArrayList<WarehouseVO>();
		ArrayList<WarehouseVO> now=new ArrayList<WarehouseVO>();
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
