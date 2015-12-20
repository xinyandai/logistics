package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeArrivalService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.common.dataservice.orderdataservice.OfficeArrivalListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;

public class OfficeArrival implements OfficeArrivalService {

	private OfficeArrivalListService officeArrivalData ;
	public OfficeArrival() {
		officeArrivalData = new RmiClient().get(OfficeArrivalListService.class);
	}

	public boolean creat(OfficeArrivalListVO o) {
		OfficeArrivalListPO newPO = o.toPO(State.SUBMITTED); 
		try {
			return officeArrivalData.add(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<OfficeArrivalListVO> getAll() {
		ArrayList<OfficeArrivalListVO> newVOs = new ArrayList<OfficeArrivalListVO>();
		ArrayList<OfficeArrivalListPO> POs = null;
		try {
			 POs = officeArrivalData.getAll(Main.currentUser.getId());
			 for(int i =0;i<POs.size();i++){
			newVOs.add(new OfficeArrivalListVO(POs.get(i)));
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return newVOs;
	}

	public boolean update(OfficeArrivalListVO o){
		OfficeArrivalListPO newPO = o.toPO(State.SUBMITTED); 
		try {
			return officeArrivalData.update(newPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
}
