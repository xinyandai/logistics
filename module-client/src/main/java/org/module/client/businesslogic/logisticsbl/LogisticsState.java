package org.module.client.businesslogic.logisticsbl;

import java.rmi.RemoteException;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.common.dataservice.logisticsdataservice.Logisticsdataservice;
import org.module.common.po.LogisticsPO;

public class LogisticsState {

	private Logisticsdataservice data = new RmiClient().get(Logisticsdataservice.class);
	
	
	
	 public boolean creat(LogisticsVO logisticsVO){
		 try {
			return this.data.add(logisticsVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		 return false;
	 }
	
     public boolean updateLocationAndTime(String id,String current,String location,String time){
    	 LogisticsVO logisticsVO = this.find(id);
    	 logisticsVO.addLocationAndTime(location, time);
    	 try {
			return this.data.updata(logisticsVO.toPO());
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
	
	public boolean update(LogisticsVO logisticsVO){
		try {
			return this.data.updata(logisticsVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
