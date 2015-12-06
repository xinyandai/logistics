package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseConfigService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.WarehouseConfigVO;
import org.module.common.dataservice.managementdataservice.WarehouseConfigDataService;
import org.module.common.po.WarehouseConfigPO;

public class WarehouseConfig implements WarehouseConfigService{

	private WarehouseConfigDataService data = new RmiClient().get(WarehouseConfigDataService.class);
	
	
	public boolean update(WarehouseConfigVO warehouseConfigVO) {
		WarehouseConfigPO warehouseConfigPO = warehouseConfigVO.toPO();
		try {
			return this.data.update(warehouseConfigPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public ArrayList<WarehouseConfigVO> getAll() {
		ArrayList<WarehouseConfigVO> re = new ArrayList<WarehouseConfigVO>();
		ArrayList<WarehouseConfigPO> pos;
		try {
			pos = this.data.getAll();
			for (WarehouseConfigPO warehouseConfigPO : pos) {
				re.add(new WarehouseConfigVO(warehouseConfigPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	
	public boolean add(WarehouseConfigVO warehouseConfigVO) {
		WarehouseConfigPO warehouseConfigPO = warehouseConfigVO.toPO();
		try {
			return this.data.add(warehouseConfigPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public WarehouseConfigVO find(String tranCenterID) {
		try {
			WarehouseConfigPO po = this.data.find(tranCenterID);
			if(po == null) return null;
			return new WarehouseConfigVO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
