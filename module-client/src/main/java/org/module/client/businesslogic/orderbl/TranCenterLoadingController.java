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

	public TranCenterLoadingController(TranCenterLoadingService loading) {
		super();
		this.loading = loading;
	}

	public boolean creat(TranCenterLoadingListVO vo) {
		return this.loading.creat(vo);
	}

	public ArrayList<TranCenterLoadingListVO> getAll() {
		return this.loading.getAll();
	}

	public double calculateDriverCost(String origin, String target) {
		return 0;
	}

	public boolean update(TranCenterLoadingListVO o) {
		return this.loading.update(o);
	}

}
