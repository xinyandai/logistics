package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.CostListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;

public class CostVerify  implements TicketAndorderVerify{

	private CostDataService data = new RmiClient().get(CostDataService.class);
	private MyList<CostListVO> list;
	
	public MyList<CostListVO> getAll() {
		this.list = new MyList<CostListVO>();
		try {
			MyList<CostListPO> pos = this.data.getAll();
			for (CostListPO costListPO : pos) {
				this.list.add(new CostListVO(costListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return this.list;
	}

	public boolean pass(int[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unpass(int[] ids) {
		// TODO Auto-generated method stub
		return false;
	}

}
