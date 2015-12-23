package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.ReceiptVO;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;

public class Income implements IncomeService {

	private ReceiptListService data = new RmiClient().get(ReceiptListService.class);

	public ArrayList<ReceiptVO> getAllIncomeList(String office,
			long startTime, long endTime) {
		
		ArrayList<ReceiptVO> vos = new ArrayList<ReceiptVO>();
		try {
			
			
			
			ArrayList<ReceiptPO> pos = this.data.getAll();
			for (ReceiptPO po : pos) {
				 /**
				 * 把时间转换为毫秒比较
				 */
	            long time = DateTransferHelper.getDate(po.getDate()).getTime();
				if(time<=endTime && time>=startTime && po.getCourier().substring(0, 6).equals(office)){
					vos.add(new ReceiptVO(po));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return vos;
	}

	public boolean add(ReceiptVO receitPO) {
		
		try {
			return this.data.add(receitPO.toPo()	);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
