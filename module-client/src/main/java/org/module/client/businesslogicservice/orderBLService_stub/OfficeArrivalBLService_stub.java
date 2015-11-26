package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.OfficeArrivalBLService;
import org.module.client.vo.OfficeArrivalListVO;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.State;


public class OfficeArrivalBLService_stub implements OfficeArrivalBLService{
	OfficeArrivalListPO oalpo;
	
	

	public ArrayList<OfficeArrivalListVO> getAll(State s) {
		// TODO �Զ����ɵķ������
		return null;
	}

	

	public boolean creat(String officeid, String date, String transportListId,
			String origin, String stateOfGoods,String state) {
		// TODO Auto-generated method stub
		return false;
	}

}
