package org.module.client.businesslogicservice.orderBLService_stub;

import java.util.ArrayList;

import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.po.State;


public class OfficeLoadingBLService_stub implements OfficeLoadingBLService{

	

	public ArrayList<OfficeLoadingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return null;
	}

	public double calculateDriverCost(String origin, String target) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean creat(String loadingDate, String officeId, String trucksId,
			String arrival, String carId, String supervision, String escort,
			String[] shippingId, String price,String state) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean creat(String loadingDate, String officeId, String trucksId,
			String city, String location, String carId, String supervision,
			String escort, String[] shippingId, String price, String state) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean creat(String loadingDate, String officeId, String trucksId,
			String city, String location, String carId, String supervision,
			String escort, String[] shippingId, String price) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
