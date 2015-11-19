package org.module.client.BL.management;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;

public class WarehouseMock implements WarehouseManageService{
	
	public ArrayList<WarehouseVO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<WarehouseVO> re = new ArrayList<WarehouseVO>();
		re.add(new WarehouseVO("10086","1","1","1","1"));
		return re;
	}

	public WarehouseVO modify(WarehouseVO ware) {
		// TODO Auto-generated method stub
		WarehouseVO re = new WarehouseVO("10086","1","1","1","1");
		return re;
	}

	public WarehouseVO outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		WarehouseVO re = new WarehouseVO("10086","1","1","1","1");
		return re;
	}

	public WarehouseVO goDown(GoDownEntryVO w) {
		// TODO Auto-generated method stub
		WarehouseVO re = new WarehouseVO("10086","1","1","1","1");
		return re;
	}

	public void setBorderline(String id, String qu, double a) {
		// TODO Auto-generated method stub		
	}

}
