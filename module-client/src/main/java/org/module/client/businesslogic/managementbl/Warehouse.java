package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;

public class Warehouse implements WarehouseManageService {

	private WarahouseDataService data = new RmiClient().get(WarahouseDataService.class);;
	public ArrayList<WarehouseVO> getAll() {
		return null;
	}

	public WarehouseVO modify(WarehouseVO ware) {
		// TODO Auto-generated method stub
		return null;
	}

	public WarehouseVO outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		return null;
	}

	public WarehouseVO goDown(GoDownEntryVO w) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBorderline(String id, String qu, double a) {

	}

	

}
