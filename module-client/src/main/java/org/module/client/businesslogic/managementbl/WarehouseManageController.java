package org.module.client.businesslogic.managementbl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.businesslogicservice.managementBLservice.WarehouseManageBLService;
import org.module.client.vo.WarehouseVO;

public class WarehouseManageController implements WarehouseManageBLService{

	
	private WarehouseManageService warehouse ;
	private ArrayList<WarehouseVO> list;
	public WarehouseManageController(WarehouseManageService warehouse) {
		super();
		this.warehouse = warehouse;
	}

	public WarehouseManageController() {
		this.warehouse = new Warehouse();
	}
	
	public ArrayList<WarehouseVO> getAll() {
		return list = warehouse.getAll();
	}

	public boolean modify(WarehouseVO vo) {
		for (WarehouseVO warehouseVO : list) {
			if(warehouseVO.getNumber().equals(vo.getNumber())){
				warehouseVO.setDate(vo.getDate());
				warehouseVO.setJia(vo.getJia());
				warehouseVO.setPai(vo.getPai());
				warehouseVO.setQu(vo.getQu());
				warehouseVO.setWei(vo.getWei());
	//			warehouseVO.setWarehouseOfWhichTranCenter(vo.getWarehouseOfWhichTranCenter());
			}
		}
		return warehouse.modify(vo);
	}
	public void export(TableModel model,File file){
		try {
			new ExcelExporter().exportTable(model, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
