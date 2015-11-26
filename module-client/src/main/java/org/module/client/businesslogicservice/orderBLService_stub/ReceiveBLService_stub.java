package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.ReceiveBLService;
import org.module.client.vo.ReceivingListVO;
import org.module.common.po.State;


public class ReceiveBLService_stub implements ReceiveBLService{

	public boolean creat(String date, String location, String origin,
			String estination, String orderId,String state) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ReceivingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
