package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.SendingService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.SendingListVO;
import org.module.common.dataservice.orderdataservice.SendingListService;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.SendingListPO;

public class Sending implements SendingService {
	private SendingListService sendingData = new RmiClient().get(SendingListService.class);
	public Sending() {
		// TODO Auto-generated constructor stub
	}

	public boolean creat(SendingListVO o) {
		// TODO Auto-generated method stub
		//SendingListPO newPO = new SendingListPO(o.getDate(),o.getShippingId(),o.getSendMember(),o.g) 
		return false;
	}

	public ArrayList<SendingListVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
