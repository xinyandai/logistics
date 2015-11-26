package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
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
		// TODO Auto-generated method stub
		return warehouse.getAll();
	}

	public boolean modify(String id, String qu, String pai, String jia,
			String wei) {
		// TODO Auto-generated method stub
		return warehouse.modify(new WarehouseVO(id, qu, pai,jia, wei));
	}

	public boolean outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		return warehouse.outBound(w);
	}

	public boolean goDown(GoDownEntryVO w) {
		// TODO Auto-generated method stub
		return warehouse.goDown(w);
	}

	public void setBorderline(String id, String qu, double a) {
		// TODO Auto-generated method stub
		
	}

}
