package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterLoadingService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;
import org.module.common.po.State;

public class TranCenterLoadingController implements TranCenterLoadingBLService {

	private TranCenterLoadingService loading;
//	private LogisticsService logistics;
	public TranCenterLoadingController() {

		this.loading = new TranCenterLoading();
//		this.logistics = new Logistics();
	}

	public TranCenterLoadingController(TranCenterLoadingService loading) {
		super();
		this.loading = loading;
//		this.logistics = logistics;
	}

	public boolean creat(String loadingDate, String officeId, String trucksId,
			String city,String location, String carId, String supervision, String escort,
			String[] shippingId, String price,String state) {
		// TODO Auto-generated method stub
		return this.loading.creat(new TranCenterLoadingListVO( loadingDate,  officeId,  trucksId,
				 city, location,  carId,  supervision,  escort,
				 shippingId,  price,state));
	}

	public ArrayList<TranCenterLoadingListVO> getAll(State s) {
		// TODO Auto-generated method stub
		return this.loading.getAll(s);
	}

	public double calculateDriverCost(String origin, String target) {
		// TODO Auto-generated method stub
		return 0;
	}

}
