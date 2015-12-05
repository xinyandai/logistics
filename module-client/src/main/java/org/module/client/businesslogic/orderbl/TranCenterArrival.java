package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterArrivalService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.TranCenterArrivalListVO;
import org.module.common.dataservice.orderdataservice.TranCenterArrivalListService;
import org.module.common.po.State;
import org.module.common.po.TranCenterArrivalListPO;

public class TranCenterArrival implements TranCenterArrivalService {
	private TranCenterArrivalListService tranCenterArrivalListData ;
	public TranCenterArrival() {
		// TODO Auto-generated constructor stub
		tranCenterArrivalListData = new RmiClient().get(TranCenterArrivalListService.class);
	}

	public boolean creat(TranCenterArrivalListVO o) {
		// TODO Auto-generated method stub
		TranCenterArrivalListPO newPO = new TranCenterArrivalListPO(o.getTransId(),o.getDate(),o.getTransportListId(),o.getOrigin(),o.getStateOfGoods(),o.getState()); 
		try {
			return tranCenterArrivalListData.add(newPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<TranCenterArrivalListVO> getAll(State s) {
		// TODO Auto-generated method stub
		ArrayList<TranCenterArrivalListVO> newVOs = new ArrayList<TranCenterArrivalListVO>();
		ArrayList<TranCenterArrivalListPO> POs = null;
		try {
			 POs = tranCenterArrivalListData.getByState(s);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new TranCenterArrivalListVO(POs.get(i).getTransId(),POs.get(i).getDate(),POs.get(i).getTransportListId(),POs.get(i).getOrigin(),POs.get(i).getStateOfGoods(),POs.get(i).getState()));
		}
		return newVOs;
		
	}

}
