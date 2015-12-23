package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
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
		boolean re = true;
		for(int i = indexes.length - 1; i>=0; i--){
			TranCenterLoadingListVO loadingListVO = this.list.get(indexes[i]);
			
			try {
				if(this.updateLogistics(loadingListVO)){
					this.list.remove(indexes[i]);
					loadingListVO.setState(State.PASS);
					re = re &&this.loadingListService.update(loadingListVO.toPO());
				}
				
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return re;
	}
	
	private boolean updateLogistics(TranCenterLoadingListVO loadingListVO){
		String[] s = loadingListVO.getShippingId();
		String date = DateTransferHelper.getString(new Date());
		String currentCity = loadingListVO.getCity();
		String location = loadingListVO.getLocation();
		boolean re = true;
		for (String id : s) {
			LogisticsVO logisticsVO = this.logistics.find(id);
			if(logisticsVO!=null){
				logisticsVO.addLocationAndTime(location, date);
			logisticsVO.setLocation(currentCity);
			this.logistics.update(logisticsVO);
			}else{
				re =false;
			}
			
		}
		return re;
		
	}
	
	public boolean unpass(int[] indexes){
		boolean re = true;
		for(int i = indexes.length-1; i>=0; i--){
			TranCenterLoadingListVO loadingListVO = this.list.remove(indexes[i]);
			loadingListVO.setState(State.UNPASS);
			try {
				re = re &&this.loadingListService.update(loadingListVO.toPO());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return re;
	}
}
