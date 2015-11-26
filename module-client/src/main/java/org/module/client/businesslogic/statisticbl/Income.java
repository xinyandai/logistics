package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.vo.ReceiptVO;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;

public class Income implements IncomeService {

	private ReceiptListService data ;

	public ArrayList<ReceiptVO> getAllIncomeList(String office,
			double startTime, double endTime) {
		ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		try {
			ArrayList<ReceiptPO> pos = this.data.getAll();
			for (ReceiptPO po : pos) {
				vos.add(new ReceiptVO(po.getDate() , 
						po.getMoney() ,
						po.getCourier() ,
						po.getOrderId()
						)
				);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public boolean add(ReceiptVO po) {
		
		try {
			return this.data.add(new ReceiptPO(po.getDate() , 
					po.getMoney()+"" ,
					po.getCourier() ,
					po.getOrderId(),
					State.SUBMITTED
					)
			);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
