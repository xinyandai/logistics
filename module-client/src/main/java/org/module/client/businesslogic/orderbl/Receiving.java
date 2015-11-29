package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.ReceiveService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.ReceivingListVO;
import org.module.common.dataservice.orderdataservice.ReceiveListService;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;

public class Receiving implements ReceiveService {
	private ReceiveListService receivingData ;
	public Receiving() {
		receivingData = new RmiClient().get(ReceiveListService.class);
	}

	public boolean creat(ReceivingListVO o) {
		// TODO Auto-generated method stub
		ReceivingListPO newPO = new ReceivingListPO(o.getDate(),o.getReceiver(),
				o.getOrderId(),o.getState()); 
		try {
			return receivingData.add(newPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<ReceivingListVO> getAll(State s) {
		ArrayList<ReceivingListVO> newVOs = new ArrayList<ReceivingListVO>();
		ArrayList<ReceivingListPO> POs = null;
		try {
			 POs = receivingData.getByState(s);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new ReceivingListVO(POs.get(i).getDate(),POs.get(i).getReceiver(),
					POs.get(i).getOrderId(),POs.get(i).getState()));
		}
		return newVOs;
	}

}
