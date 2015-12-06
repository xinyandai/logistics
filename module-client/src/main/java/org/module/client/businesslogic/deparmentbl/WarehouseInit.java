package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;

import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.managementdataservice.WarehouseConfigDataService;
import org.module.common.po.WarehouseConfigPO;

public class WarehouseInit {
	private WarehouseConfigDataService data = new RmiClient().get(WarehouseConfigDataService.class);
	public boolean add(String tranCenterID){
	
	     
		try {
			String[] qus = {"001"};
			String[] sizeOfQu = {"100"};
			String[] borderline = {"80"};
			this.data.add(new WarehouseConfigPO(tranCenterID,qus,sizeOfQu, borderline));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
