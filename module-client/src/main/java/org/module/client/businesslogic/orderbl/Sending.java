package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.order.SendingService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.SendingListVO;
import org.module.common.dataservice.orderdataservice.SendingListService;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;


public class Sending implements SendingService {
	private SendingListService sendingData ;
	public Sending() {
		// TODO Auto-generated constructor stub
		sendingData = new RmiClient().get(SendingListService.class);
	}

	public boolean creat(SendingListVO o) {
		// TODO Auto-generated method stub
		SendingListPO newPO = new SendingListPO(o.getDate(),o.getShippingId(),o.getSendMember(),o.getState().toString()); 
		try {
			return sendingData.add(newPO);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<SendingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		ArrayList<SendingListVO> newVOs = new ArrayList<SendingListVO>();
		ArrayList<SendingListPO> POs = null;
		try {
			 POs = sendingData.getByState(s);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<POs.size();i++){
			newVOs.add(new SendingListVO(POs.get(i).getDate(),POs.get(i).getShippingId(),POs.get(i).getSendMember(),POs.get(i).getState().toString()));
		}
		return newVOs;
	}

}
