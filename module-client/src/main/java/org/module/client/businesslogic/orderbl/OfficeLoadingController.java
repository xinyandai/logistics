package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.OfficeLoadingService;
import org.module.client.businesslogicservice.orderBLservice.OfficeLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;



public class OfficeLoadingController implements OfficeLoadingBLService {
	
	private OfficeLoadingService officeLoading;
	private CalculateDriverCost cityAndCost;
	private ArrayList<OfficeLoadingListVO> list;
	
	
	public OfficeLoadingController() {
		this.officeLoading = new OfficeLoading();
		this.cityAndCost = new CalculateDriverCost();
	}

	public OfficeLoadingController(OfficeLoadingService officeLoading ) {
		super();
		this.officeLoading = officeLoading;
	}


	public ArrayList<OfficeLoadingListVO> getAll() {
		
		this.list =  this.officeLoading.getAll();
		return this.list;
	}

	public double calculateDriverCost(String origin, String target) {
		
		return this.cityAndCost.calculateDriverCostByCityName(origin, target);
	}

	public boolean creat(OfficeLoadingListVO vo) {
		this.list.add(vo);
		return this.officeLoading.creat(vo);
	}

	public boolean update(OfficeLoadingListVO vo) {
		for (OfficeLoadingListVO officeLoadingListVO : list) {
			if(officeLoadingListVO.getTrucksId().equals(vo.getTrucksId())){
				officeLoadingListVO.setCarId(vo.getCarId());
				officeLoadingListVO.setCity(vo.getCity());
				officeLoadingListVO.setEscort(vo.getEscort());
				officeLoadingListVO.setLoadingDate(vo.getLoadingDate());
				officeLoadingListVO.setLocation(vo.getLocation());
				officeLoadingListVO.setOfficeId(vo.getOfficeId());
				officeLoadingListVO.setPrice(vo.getPrice());
				officeLoadingListVO.setShippingId(vo.getShippingId());
				officeLoadingListVO.setState(vo.getState());
				officeLoadingListVO.setSupervision(vo.getSupervision());
				return this.officeLoading.update(vo);
			}
		}
		return false;
	}

	
	
	public String[] getCityArray() {
		return this.cityAndCost.getAllCitiesArray();
	}

	
}
