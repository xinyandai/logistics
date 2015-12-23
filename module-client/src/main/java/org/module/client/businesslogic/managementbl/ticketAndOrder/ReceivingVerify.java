package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.ReceivingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.ReceiveListService;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;

public class ReceivingVerify  implements TicketAndorderVerify{

	private ReceiveListService receiveListDataGetter = new RmiClient().get(ReceiveListService.class);
	private MyList<ReceivingListVO> list ;
	private LogisticsState logistics = new LogisticsState();
	
	public MyList<ReceivingListVO> getAll(){
		try {
			MyList<ReceivingListPO> pos = this.receiveListDataGetter.getByState(State.SUBMITTED);
			list = new MyList<ReceivingListVO>();
			for (ReceivingListPO receivingListPO : pos) {
				list.add(new ReceivingListVO(receivingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return this.list;
	}
	
	public boolean pass(int[] indexes){
		
		boolean re = true;
		try {
			for(int i = indexes.length-1; i>=0; i--){
				ReceivingListVO vo = this.list.get(indexes[i]);
				
				
				
				LogisticsVO logisticsVO = this.logistics.find(vo.getOrderId());
				if(logisticsVO==null){
					return false;
				}
				vo.setState(State.PASS);
				re = re &&this.receiveListDataGetter.update(vo.toPO());
				this.list.remove(indexes[i]);
				
				logisticsVO.setCompleted(true);
				logisticsVO.setLocation("订单已签收");
				logisticsVO.addLocationAndTime(vo.getReceiver()+"已经签收", DateTransferHelper.getString(new Date()));
				re  = re &&this.logistics.update(logisticsVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public boolean unpass(int[] indexes){
		
		boolean re = true;
		try {
			for(int i = indexes.length-1; i>=0; i++){
				ReceivingListVO vo = this.list.remove(indexes[i]);
				vo.setState(State.UNPASS);
				re = re &&this.receiveListDataGetter.update(vo.toPO());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}
	
}
