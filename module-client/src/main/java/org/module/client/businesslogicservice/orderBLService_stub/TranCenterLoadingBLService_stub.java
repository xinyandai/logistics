package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.po.State;


public class TranCenterLoadingBLService_stub implements TranCenterLoadingBLService{

	public boolean creat(String loadingDate, String transportListId,
			String arrival, String carId, String supervision, String escort,
			String[] shippingId, String price,String state) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<TranCenterLoadingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	public double calculateDriverCost(String origin, String target) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
