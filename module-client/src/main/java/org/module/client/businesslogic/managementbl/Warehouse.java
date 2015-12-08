package org.module.client.businesslogic.managementbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseManageService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.client.vo.WarehouseVO;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.WarehousePO;

public class Warehouse implements WarehouseManageService {

	private WarahouseDataService data = new RmiClient().get(WarahouseDataService.class);
	public ArrayList<WarehouseVO> getAll() {
		ArrayList<WarehouseVO> vos = new ArrayList<WarehouseVO>();
		try {
			//当前中转中心id
			ArrayList<WarehousePO> pos = this.data.getAll(Main.currentUser.getDepartmeny());
			for (WarehousePO warehousePO : pos) {
				vos.add(
						new WarehouseVO(
								warehousePO
								)
						);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public boolean modify(WarehouseVO warehouseVO) {
		WarehousePO po = 
				warehouseVO.toVO();
		try {
			return this.data.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean outBound(OutBoundListVO w) {
		// TODO Auto-generated method stub
		/*try {
			return this.data.delete(
					w.getId()
					);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
							w.getWarehouseOfWhichTranCenter(),
							w.getDate()
							)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*public boolean setBorderline(String id, String qu, double a) {

		try {
			return this.data.setBorderline(new BorderlinePO(id,qu,a));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}*/
	

}
