package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.TransportListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TransportListService;
import org.module.common.po.State;
import org.module.common.po.TransportListPO;

public class TransportVerify  implements TicketAndorderVerify{

	private TransportListService transport = new RmiClient().get(TransportListService.class);
	private LogisticsState logistics = new LogisticsState();
	private MyList<TransportListVO> list;
	
	public MyList<TransportListVO> getAll(){
		list = new MyList<TransportListVO>();
		try {
			MyList<TransportListPO> pos = this.transport.getByState(State.SUBMITTED);
			for (TransportListPO transportListPO : pos) {
				list.add(new TransportListVO(transportListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean pass(int[] index){
		try{
			for(int i = index.length-1; i>=0; i--){
				TransportListVO transportListVO = this.list.get(index[i]);
				transportListVO.setState(State.PASS);
				
				this.updateLogistics(transportListVO);
				
				this.transport.update(transportListVO.toPO());
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	private void updateLogistics(TransportListVO transportListVO){
		String[] ordersArray = transportListVO.getShippingId();
		for (String order : ordersArray) {
			LogisticsVO logisticsVO = this.logistics.find(order);
			logisticsVO.setLocation("正在中转");
			this.logistics.update(logisticsVO);
		}
		
	}
	
	
	public boolean unpass(int[] index){
		try{
			for(int i = index.length-1; i>=0; i--){
				TransportListVO vo = this.list.get(index[i]);
				vo.setState(State.UNPASS);
				this.transport.update(vo.toPO());
			}
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
}
