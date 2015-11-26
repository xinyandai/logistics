package org.module.client.businesslogic.logisticsbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.common.dataservice.logisticsdataservice.Logisticsdataservice;
import org.module.common.po.LogisticsPO;

public class Logistics implements LogisticsService{
	
	private Logisticsdataservice data = new RmiClient().get(Logisticsdataservice.class);

	public LogisticsVO showState(String id) {
		try {
			LogisticsPO po = this.data.getOrder(id);
			return new LogisticsVO(
					po.getOrderId(),
					po.getOrigin(),
					po.getEstination(),
					po.getLocation(),
					po.getHistoryLocation(),
					po.getHistoryTime(),
					po.isCompleted());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public boolean setState(LogisticsVO vo) {
		
		try {
			return this.data.updata(new LogisticsPO(
						vo.getOrderId(),
						vo.getOrigin(),
						vo.getEstination(),
						vo.getLocation(),
						vo.getHistoryLocation(),
						vo.getHistoryTime(),
						vo.isCompleted()
						)
			);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
