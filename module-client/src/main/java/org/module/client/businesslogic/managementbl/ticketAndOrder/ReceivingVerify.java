package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.Date;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
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
		
		try {
			for(int i = indexes.length-1; i>=0; i++){
				ReceivingListVO vo = this.list.remove(indexes[i]);
				vo.setState(State.PASS);
				this.receiveListDataGetter.update(vo.toPO());
				
				LogisticsVO logisticsVO = this.logistics.find(vo.getOrderId());
				logisticsVO.setCompleted(true);
				logisticsVO.setLocation("订单已签收");
				logisticsVO.addLocationAndTime(vo.getReceiver()+"已经签收", new Date().toString());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean unpass(int[] indexes){
		
		
		try {
			for(int i = indexes.length-1; i>=0; i++){
				ReceivingListVO vo = this.list.remove(indexes[i]);
				vo.setState(State.UNPASS);
				this.receiveListDataGetter.update(vo.toPO());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
