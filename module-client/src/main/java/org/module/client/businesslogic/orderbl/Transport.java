package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TransportService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.vo.TransportListVO;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.TransportListPO;

public class Transport implements TransportService {
	private TransportListService transportData ;
	public Transport() {
		transportData = new RmiClient().get(TransportListService.class);
	}

	public boolean creat(TransportListVO o) {
		TransportListPO newPO = o.toPO(); 
		try {
			return transportData.add(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TransportListVO> getAll() {
		ArrayList<TransportListVO> newVOs = new ArrayList<TransportListVO>();
		ArrayList<TransportListPO> POs = null;
		try {
			 POs = transportData.getAll(Main.currentUser.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new TransportListVO(POs.get(i)));
		}
		return newVOs;
	}

	public boolean update(TransportListVO o) {
		try {
			return this.transportData.update(o.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
