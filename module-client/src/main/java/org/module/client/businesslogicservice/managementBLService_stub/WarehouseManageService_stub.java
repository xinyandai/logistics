package org.module.client.businesslogicservice.managementBLService_stub;

import java.io.File;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;


public class WarehouseManageService_stub implements  WarehouseManageBLService{

	public ArrayList<WarehouseVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean modify(String id, String qu, String pai, String jia,
			String wei) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean outBound(OutBoundListVO w) {
		return false;
		// TODO Auto-generated method stub
	}

	public boolean goDown(GoDownEntryVO w) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setBorderline(String id, String qu, double a) {
		// TODO Auto-generated method stub		
	}

	public boolean modify(String id, String qu, String pai, String jia,
			String wei, String warehouseOfWhichTranCenter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modify(WarehouseVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public void export(TableModel model, File file) {
		// TODO Auto-generated method stub
		
	}

}
