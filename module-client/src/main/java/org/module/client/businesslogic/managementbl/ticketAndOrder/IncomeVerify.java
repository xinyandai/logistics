
package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.businesslogic.statisticbl.Account;
import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.ReceiptVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;

public class IncomeVerify  implements TicketAndorderVerify{

	private MyList<ReceiptVO> list ;
	private AccountService account = new Account();
	private ReceiptListService data = new RmiClient().get(ReceiptListService.class);
	
	public IncomeVerify(){
		
	}
	
	public MyList<ReceiptVO> getAll() {
		this.list = new MyList<ReceiptVO>();
		try {
			MyList<ReceiptPO> pos = this.data.getAllBySatte(State.SUBMITTED);
			for (ReceiptPO costListPO : pos) {
				this.list.add(new ReceiptVO(costListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.list;
	}

	public boolean pass(int[] ids) {
		boolean re = true;
		if(this.list==null){
			this.list = this.getAll();
		}
		try {
			for (int i = ids.length-1; i>=0 ; i--) {
				ReceiptVO vo = this.list.remove(ids[i]);
			    vo.setState(State.PASS);
			    re = re && this.data.update(vo.toPo())
			    		&& this.account.income(this.account.getDefaultAccount().getId(), vo.getMoney());
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	public boolean unpass(int[] ids) {
		boolean re = true;
		if(this.list==null){
			this.list = this.getAll();
		}
		try {
			for (int i = ids.length-1; i>=0 ; i--) {
				ReceiptVO vo = this.list.remove(ids[i]);
			    vo.setState(State.UNPASS);
			    re = re && this.data.update(vo.toPo());
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

}
