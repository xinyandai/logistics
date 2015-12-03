package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;
import java.util.Date;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.WarehouseVO;

public class WarehouseManageController implements WarehouseManageBLService{

	
	private WarehouseManageService warehouse ;
	public WarehouseManageController(WarehouseManageService warehouse) {
		super();
		this.warehouse = warehouse;
	}

	public WarehouseManageController() {
		this.warehouse = new Warehouse();
	}
	
	public ArrayList<WarehouseVO> getAll() {
		return warehouse.getAll();
	}

	public boolean modify(String id, String qu, String pai, String jia,
			String wei,String 	warehouseOfWhichTranCenter) {
		return warehouse.modify(new WarehouseVO(
				id, qu, pai,jia, wei,warehouseOfWhichTranCenter,new Date().getTime()));
	}
}
