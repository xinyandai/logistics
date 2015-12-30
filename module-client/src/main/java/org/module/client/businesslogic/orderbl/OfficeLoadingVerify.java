package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogic.logisticsbl.LogisticsState;
import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeLoadingListService;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;

public class OfficeLoadingVerify  implements TicketAndorderVerify{
	
	private OfficeLoadingListService loadingListService = new RmiClient().get(OfficeLoadingListService.class);
	private MyList<OfficeLoadingListVO> list;
	private LogisticsState logistics = new LogisticsState();
	
	public MyList<OfficeLoadingListVO> getAll(){
		list = new MyList<OfficeLoadingListVO>();
		try {
			MyList<OfficeLoadingListPO> pos = this.loadingListService.getByState(State.SUBMITTED);
			for (OfficeLoadingListPO officeLoadingListPO : pos) {
				this.list.add(new OfficeLoadingListVO(officeLoadingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean pass(int[] indexes){
		boolean re = true;
		for(int i = indexes.length - 1; i>=0; i--){
			OfficeLoadingListVO officeLoadingListVO = this.list.get(indexes[i]);
			
			try {
				if(this.updateLogistics(officeLoadingListVO)){
					this.list.remove(indexes[i]);
					officeLoadingListVO.setState(State.PASS);
					re = re && this.loadingListService.update(officeLoadingListVO.toPO());
				}
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return re;
	}
	
	private boolean updateLogistics(OfficeLoadingListVO officeLoadingListVO){
		String[] s = officeLoadingListVO.getShippingId();
		String date = DateTransferHelper.getString( new Date() );
		String currentCity = officeLoadingListVO.getCity();
		String location = officeLoadingListVO.getLocation();
		boolean re = true;
		for (String id : s) {
			LogisticsVO logisticsVO = this.logistics.find(id);
			if(logisticsVO!=null){
				logisticsVO.addLocationAndTime("已到达："+currentCity+" 正在发往："+location, date);
			    logisticsVO.setLocation(currentCity);
			    re = re&&this.logistics.update(logisticsVO);
			}else{
				re = false;
			}
			
		}
		return re;
		
	}
	
	public boolean unpass(int[] indexes){
		boolean re = true; 
		for(int i = indexes.length - 1; i>=0; i--){
			OfficeLoadingListVO officeLoadingListVO = this.list.remove(indexes[i]);
			officeLoadingListVO.setState(State.UNPASS);
			try {
				re = re && this.loadingListService.update(officeLoadingListVO.toPO());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return re;
	}
}
