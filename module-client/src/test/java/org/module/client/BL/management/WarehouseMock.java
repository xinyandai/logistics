package org.module.client.BL.management;

import java.util.ArrayList;
import java.util.Date;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;

public class WarehouseMock implements WarehouseManageService{
	
	public ArrayList<WarehouseVO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<WarehouseVO> re = new ArrayList<WarehouseVO>();
		re.add(new WarehouseVO("10086","1","1","1","1","warehouse",DateTransferHelper.getString(new Date())));
		return re;
	}

	public boolean modify(WarehouseVO ware) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean goDown(GoDownEntryVO w) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean setBorderline(String id, String qu, double a) {
		return true;
		// TODO Auto-generated method stub		
	}

}
