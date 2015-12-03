package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.common.dataservice.logisticsdataservice.Logisticsdataservice;
import org.module.common.po.LogisticsPO;

public class LogisticsState {

	private Logisticsdataservice data = new RmiClient().get(Logisticsdataservice.class);
	
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
	
	public LogisticsVO find(String id){
		LogisticsPO po;
		try {
			po = this.data.getOrder(id);
			return new LogisticsVO(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}
