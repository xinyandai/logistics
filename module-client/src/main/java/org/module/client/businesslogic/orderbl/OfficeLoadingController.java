package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeLoadingService;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.common.po.State;

public class OfficeLoadingController implements OfficeLoadingBLService {
	private OfficeLoadingService officeLoading;
//	private LogisticsService logistics;
	public OfficeLoadingController() {
		this.officeLoading = new OfficeLoading();
//		this.logistics = new Logistics();
	}

	public OfficeLoadingController(OfficeLoadingService officeLoading ) {
		super();
		this.officeLoading = officeLoading;
//		this.logistics = logistics;
	}

	public boolean creat(String loadingDate, String officeId, String trucksId,
			String city,String location, String carId, String supervision, String escort,
			String[] shippingId, String price) {
		
		return this.officeLoading.creat(new OfficeLoadingListVO( loadingDate,  officeId,  trucksId,
			 city, location,  carId,  supervision,  escort,
			 shippingId,  price,State.SUBMITTED));
	}

	public ArrayList<OfficeLoadingListVO> getAll(State s) {
		
		return this.officeLoading.getAll(s);
	}

	public double calculateDriverCost(String origin, String target) {
		return 0;
	}

	
}
