package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.order.TranCenterLoadingService;
import org.module.client.businesslogicservice.orderBLservice.TranCenterLoadingBLService;
import org.module.client.vo.OfficeLoadingListVO;
import org.module.client.vo.TranCenterLoadingListVO;

public class TranCenterLoadingController implements TranCenterLoadingBLService {

	private TranCenterLoadingService loading;
	private CalculateDriverCost cityAndCost;
	private ArrayList<TranCenterLoadingListVO> list;
	
	public TranCenterLoadingController() {

		this.loading = new TranCenterLoading();
		this.cityAndCost = new CalculateDriverCost();
	}

	public TranCenterLoadingController(TranCenterLoadingService loading) {
		super();
		this.loading = loading;
	}

	public boolean creat(TranCenterLoadingListVO vo) {
		this.list.add(vo);
		return this.loading.creat(vo);
	}

	public ArrayList<TranCenterLoadingListVO> getAll() {
		this.list =  this.loading.getAll();
		return list;
	}

	public double calculateDriverCost(String origin, String target) {
		return this.cityAndCost.calculateDriverCostByCityName(origin, target);
	}

	public boolean update(TranCenterLoadingListVO vo) {
		for (TranCenterLoadingListVO tranCenterLoadingListVO : list) {
			if(tranCenterLoadingListVO.getTrucksId().equals(vo.getTrucksId())){
				tranCenterLoadingListVO.setCarId(vo.getCarId());
				tranCenterLoadingListVO.setCity(vo.getCity());
				tranCenterLoadingListVO.setEscort(vo.getEscort());
				tranCenterLoadingListVO.setLoadingDate(vo.getLoadingDate());
				tranCenterLoadingListVO.setLocation(vo.getLocation());
				tranCenterLoadingListVO.setOfficeId(vo.getOfficeId());
				tranCenterLoadingListVO.setPrice(vo.getPrice());
				tranCenterLoadingListVO.setShippingId(vo.getShippingId());
				tranCenterLoadingListVO.setState(vo.getState());
				tranCenterLoadingListVO.setSupervision(vo.getSupervision());
				return this.loading.update(vo);
			}
		}
		return false;
	}

	public String[] getCityArray() {
		return this.cityAndCost.getAllCitiesArray();
	}

}
