package org.module.client.businesslogic.managementbl.warehouseTicket;

import java.rmi.RemoteException;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.WarehousePO;

public class WarehouseAdjust {
	
	private WarahouseDataService data = new RmiClient().get(WarahouseDataService.class);
	
	public boolean outBound(OutBoundListVO w) {

		try {
			return this.data.delete(
					this.getWarehousePO(w)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public WarehousePO getWarehousePO(OutBoundListVO w){
		try {
			return this.data.find("",w.getId());
		} catch (RemoteException e) {
		}
		return null;
	}
	

	public WarehousePO getWarehousePO(GoDownEntryVO w){
		return new WarehousePO(
				w.getId(),
				w.getQu(),
				w.getPai(),
				w.getJia(),
				w.getWei(),
				w.getWarehouseOfWhichTranCenter(),
				w.getDate()
				);
	}
	
	public boolean goDown(GoDownEntryVO w) {
		try {
			return this.data.delete(
					this.getWarehousePO(w)
					);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
