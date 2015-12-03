package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.LogisticsVO;
import org.module.client.vo.MailingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.MailingListService;
import org.module.common.po.MailingListPO;
import org.module.common.po.State;

public class MainlingVerify {
	private MailingListService data = new RmiClient().get(MailingListService.class);
	private MyList<MailingListVO> list ;
	private LogisticsState logistics = new LogisticsState();
	public MainlingVerify(){
		
	}
	public MyList<MailingListVO> getAll(){
		MyList<MailingListVO> re = new MyList<MailingListVO>();
		try {
			ArrayList<MailingListPO> pos = this.data.getByState(State.SUBMITTED);
			for (MailingListPO mailingListPO : pos) {
				re.add(new MailingListVO(mailingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean pass(int[] ids){
		if(this.list==null){
			this.list = this.getAll();
		}
		
		try {for (int i : ids) {
			MailingListVO vo = this.list.get(i);
			this.data.update(vo.toPO(State.PASS));
			LogisticsVO logisticsVO = this.logistics.find(vo.getId());
			logisticsVO.addLocationAndTime("", "");
			
		}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	
	
}
