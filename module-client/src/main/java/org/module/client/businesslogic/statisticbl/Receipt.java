package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.vo.ReceiptVO;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;

public class Receipt {
	
	private ReceiptListService data = new RmiClient().get(ReceiptListService.class);

	
	public ArrayList<ReceiptVO> getAll(){
		ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		try {
			ArrayList<ReceiptPO> pos = this.data.getAll(Main.currentUser.getId());
			for (ReceiptPO po : pos) {
	            vos.add(new ReceiptVO(po));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}
	
	public boolean add(ReceiptVO vo) {
		try {
			return this.data.add(vo.toPo());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(ReceiptVO vo){
		try {
			return this.data.update(vo.toPo());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
