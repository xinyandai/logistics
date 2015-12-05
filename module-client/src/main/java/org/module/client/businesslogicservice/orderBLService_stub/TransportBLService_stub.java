package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.TransportBLService;
import org.module.client.vo.TransportListVO;
import org.module.common.po.State;


public class TransportBLService_stub implements TransportBLService{

	public boolean creat(String car, String loadingDate, String transId,
			String carId, String origin, String arrival, String counterId,
			String supervision, String[] shippingId, String price,String state) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<TransportListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean creat(String car, String loadingDate, String transId,
			String carId, String origin, String arrival, String counterId,
			String supervision, String[] shippingId, String price) {
		// TODO Auto-generated method stub
		return false;
	}


}
