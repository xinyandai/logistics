package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.businesslogicservice.statistic.AccountService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.CostListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;
import org.module.common.po.State;

public class CostVerify  implements TicketAndorderVerify{

	private CostDataService data = new RmiClient().get(CostDataService.class);
	private MyList<CostListVO> list;
	private AccountService account = new Account();
	
	public MyList<CostListVO> getAll() {
		this.list = new MyList<CostListVO>();
		try {
			MyList<CostListPO> pos = this.data.getAllBySatte(State.SUBMITTED);
			for (CostListPO costListPO : pos) {
				this.list.add(new CostListVO(costListPO));
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
				CostListVO vo = this.list.get(ids[i]);
				//付款，更新卡余额
			    if(this.account.pay(vo.getAccout(), vo.getMoney())){
			    	vo.setState(State.PASS);
			    	this.data.update(vo.toPO());
			    }else{
			    	return re = false;
			    }
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
				CostListVO vo = this.list.remove(ids[i]);
			    vo.setState(State.UNPASS);
			    re = re && this.data.update(vo.toPO());
		    }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return re;
	}

	
}
