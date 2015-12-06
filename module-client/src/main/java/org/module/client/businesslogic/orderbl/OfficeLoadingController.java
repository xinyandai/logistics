package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.businesslogicservice.order.OfficeLoadingService;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;



public class OfficeLoadingController implements OfficeLoadingBLService {
	private OfficeLoadingService officeLoading;

	private CalculateDriverCostService driverCost;
	
	public OfficeLoadingController() {
		this.officeLoading = new OfficeLoading();
	}

	public OfficeLoadingController(OfficeLoadingService officeLoading ) {
		super();
		this.officeLoading = officeLoading;
	}


	public ArrayList<OfficeLoadingListVO> getAll() {
		
		return this.officeLoading.getAll();
	}

	public double calculateDriverCost(String origin, String target) {
		this.driverCost =  
				this.driverCost==null? new CalculateDriverCost() : this.driverCost;
		return this.driverCost.calculateDriverCost(origin, target);
	}

	public boolean creat(OfficeLoadingListVO vo) {
		return this.officeLoading.creat(vo);
	}

	public boolean update(OfficeLoadingListVO vo) {
		return this.officeLoading.update(vo);
	}

	
}
