package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterLoadingService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.TranCenterLoadingListVO;

public class TranCenterLoadingController implements TranCenterLoadingBLService {

	private TranCenterLoadingService loading;
	public TranCenterLoadingController() {

		this.loading = new TranCenterLoading();
	}

	public boolean creat(String loadingDate, String transportListId,
			String arrival, String carId, String supervision, String escort,
			String shippingId, String price) {
		// TODO Auto-generated method stub
		return this.loading.creat(new TranCenterLoadingListVO( loadingDate,  transportListId,
			 arrival,  carId,  supervision,  escort,
			 shippingId,  price));
	}

	public ArrayList<TranCenterLoadingListVO> getAll() {
		// TODO Auto-generated method stub
		return this.loading.getAll();
	}

	public double calculateDriverCost(String origin, String target) {
		// TODO Auto-generated method stub
		return 0;
	}

}
