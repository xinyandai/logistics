package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TranCenterLoadingListService;
import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;

public class TranCenterLoadingVerify  implements TicketAndorderVerify{
	private TranCenterLoadingListService loadingListService = new RmiClient().get(TranCenterLoadingListService.class);
	private MyList<TranCenterLoadingListVO> list;
	private LogisticsState logistics = new LogisticsState();
	
	public MyList<TranCenterLoadingListVO> getAll(){
		list = new MyList<TranCenterLoadingListVO>();
		try {
			MyList<TranCenterLoadingListPO> pos = this.loadingListService.getByState(State.SUBMITTED);
			for (TranCenterLoadingListPO officeLoadingListPO : pos) {
				this.list.add(new TranCenterLoadingListVO(officeLoadingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean pass(int[] indexes){
		for(int i = indexes.length - 1; i>=0; i--){
			TranCenterLoadingListVO loadingListVO = this.list.remove(indexes[i]);
			loadingListVO.setState(State.PASS);
			try {
				this.loadingListService.update(loadingListVO.toPO());
				this.updateLogistics(loadingListVO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private void updateLogistics(TranCenterLoadingListVO loadingListVO){
		String[] s = loadingListVO.getShippingId();
		String date = new Date().toString();
		String currentCity = loadingListVO.getCity();
		String location = loadingListVO.getLocation();
		for (String id : s) {
			LogisticsVO logisticsVO = this.logistics.find(id);
			logisticsVO.addLocationAndTime(location, date);
			logisticsVO.setLocation(currentCity);
			this.logistics.update(logisticsVO);
		}
		
	}
	
	public boolean unpass(int[] indexes){
		for(int i = indexes.length-1; i>=0; i--){
			TranCenterLoadingListVO loadingListVO = this.list.remove(indexes[i]);
			loadingListVO.setState(State.UNPASS);
			try {
				this.loadingListService.update(loadingListVO.toPO());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
