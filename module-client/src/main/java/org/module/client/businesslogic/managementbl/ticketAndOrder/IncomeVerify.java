package org.module.client.businesslogic.managementbl.ticketAndOrder;

import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.vo.ReceiptVO;
import org.module.common.dataservice.MyList;

public class IncomeVerify  implements TicketAndorderVerify{

//	private MyList<ReceiptVO> list ;
	
	public MyList<ReceiptVO> getAll() {
		
		return null;
	}

	public boolean pass(int[] ids) {
		return false;
	}

	public boolean unpass(int[] ids) {
		return false;
	}

}
