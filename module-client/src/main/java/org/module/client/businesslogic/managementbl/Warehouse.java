package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.BorderlinePO;
import org.module.common.po.WarehousePO;

public class Warehouse implements WarehouseManageService {

	private WarahouseDataService data = new RmiClient().get(WarahouseDataService.class);;
	public ArrayList<WarehouseVO> getAll() {
		ArrayList<WarehouseVO> vos = new ArrayList<WarehouseVO>();
		try {
			ArrayList<WarehousePO> pos = this.data.getAll();
			for (WarehousePO warehousePO : pos) {
				vos.add(
						new WarehouseVO(
								warehousePO.getNumber(),		
								warehousePO.getQu(),
								warehousePO.getPai(),
								warehousePO.getJia(),
								warehousePO.getWei(),
								warehousePO.getWarehouseOfWhichTranCenter()
								)
						);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public boolean modify(WarehouseVO warehouseVO) {
		WarehousePO po = new WarehousePO(
			
				warehouseVO.getNumber(),		
				warehouseVO.getQu(),
				warehouseVO.getPai(),
				warehouseVO.getJia(),
				warehouseVO.getWei(),
				warehouseVO.getWarehouseOfWhichTranCenter()
				);
		try {
			return this.data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		try {
			return this.data.delete(
					w.getId()
					);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean goDown(GoDownEntryVO w) {
		try {
			return this.data.add(
					new WarehousePO(
							w.getId(),
							w.getQu(),
							w.getPai(),
							w.getJia(),
							w.getWei(),
							w.getWarehouseOfWhichTranCenter()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean setBorderline(String id, String qu, double a) {

		try {
			return this.data.setBorderline(new BorderlinePO(id,qu,a));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
