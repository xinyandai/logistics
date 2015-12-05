package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.SendingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.SendingListService;
import org.module.common.po.LogisticsPO;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;

public class SendingVerify  implements TicketAndorderVerify{

	private SendingListService sendingListDataGetter = new RmiClient().get(SendingListService.class);
	private LogisticsState logistics = new LogisticsState();
	
	private MyList<SendingListVO> list;
	
	public MyList<SendingListVO> getAll(){
		list = new MyList<SendingListVO>();
		try {
			MyList<SendingListPO> pos = this.sendingListDataGetter.getByState(State.SUBMITTED);
			for (SendingListPO sendingListPO : pos) {
				list.add(new SendingListVO(sendingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean pass(int[] indexes){
		try{
			for(int i = indexes.length - 1 ; i>=0; i--){
				SendingListVO sendingListVO = this.list.remove(indexes[i]);
				sendingListVO.setState(State.PASS);
				this.sendingListDataGetter.update(sendingListVO.toPO());
				
				LogisticsVO logisticsVO = this.logistics.find(sendingListVO.getShippingId());
				logisticsVO.setLocation("开始派件，派件员:"+sendingListVO.getSendMember());
				this.logistics.update(logisticsVO);
			}
		}catch(RemoteException e){
			
		}
		return true;
	}
	public boolean  unpass(int[] indexes){
		try{
			for(int i = indexes.length - 1 ; i>=0; i--){
				SendingListVO sendingListVO = this.list.remove(indexes[i]);
				sendingListVO.setState(State.PASS);
				this.sendingListDataGetter.update(sendingListVO.toPO());
			}
		}catch(RemoteException e){
			
		}
		return true;
	}
}
