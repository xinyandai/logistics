package org.module.client.businesslogic.logisticsbl;

import org.module.client.businesslogicservice.logistics.LogisticsService;
import org.module.client.businesslogicservice.logisticsBLservice.LogisticsBLService;
import org.module.client.vo.LogisticsVO;

public class LogisticsController implements LogisticsBLService{
	
	private LogisticsService Logistics ;
	public LogisticsController(LogisticsService car) {
		super();
		this.Logistics = car;
	}
	public LogisticsController() {
		this.Logistics = new Logistics();
	}
	
	public LogisticsVO showState(String id) {
		return Logistics.showState(id);
	}
	

	public boolean setState(String origin, String estination, String location,
			String orderId, String[] historyLocation,String[] historyTime) {
		return Logistics.setState(new LogisticsVO(origin, estination, location,
				orderId, historyLocation,historyTime,false));
	}

}
