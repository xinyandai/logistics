
package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.module.client.businesslogic.logisticsbl.LogisticsState;
import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.MailingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.MailingListService;
import org.module.common.po.MailingListPO;
import org.module.common.po.State;

public class MainlingVerify implements TicketAndorderVerify{
	private MailingListService data = new RmiClient().get(MailingListService.class);
	private MyList<MailingListVO> list ;
	private LogisticsState logistics = new LogisticsState();
	public MainlingVerify(){
		
	}
	public MyList<MailingListVO> getAll(){
		list = new MyList<MailingListVO>();
		try {
			ArrayList<MailingListPO> pos = this.data.getByState(State.SUBMITTED);
			for (MailingListPO mailingListPO : pos) {
				list.add(new MailingListVO(mailingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean pass(int[] ids){
		if(this.list==null){
			this.list = this.getAll();
		}
		boolean re = true;
		try {
			for (int i = ids.length-1; i>=0 ; i--) {
			MailingListVO vo = this.list.remove(ids[i]);
			
			vo.setState(State.PASS);
			this.data.update(vo.toPO());
			
			String[] location = {"订单已到达本地营业厅"};
			String[] time = {""+DateTransferHelper.getString(new Date())};
			 re = re && this.logistics.creat(new LogisticsVO(
					vo.getId(),
					vo.getSenderCity()+vo.getReceivePosition(),
					vo.getReceiveCity()+vo.getReceivePosition(),
					"订单已受理",
					location,
					time,
					false
					));
			
			
			
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		return re;
	}
	
	public boolean unpass(int[] ids){
		if(this.list==null){
			this.list = this.getAll();
		}
		boolean re = true;
		try {
			for (int i = ids.length-1; i>=0 ; i--) {
			MailingListVO vo = this.list.get(ids[i]);
			vo.setState(State.UNPASS);
			this.data.update(vo.toPO());
			String[] location = {"订单到达营业厅"};
			String[] time = {new Date().toString()};
			re = re && this.logistics.creat(new LogisticsVO(
					vo.getId(),
					vo.getSenderCity(),
					vo.getReceiveCity()+vo.getReceivePosition(),
					"订单拒绝受理，请联系收件员",
					location,
					time,
					false
					));
			
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}
}
